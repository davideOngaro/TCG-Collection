package com.personal.tcgcollector.service;

import com.personal.tcgcollector.client.ImportClientAPI;
import com.personal.tcgcollector.common.mapping.TcgOnePieceInputAdapter;
import com.personal.tcgcollector.common.model.TcgApiResponse;
import com.personal.tcgcollector.persistence.entities.Card;
import com.personal.tcgcollector.persistence.repositories.CardRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OnePieceInputService {

    private final TcgOnePieceInputAdapter inputAdapter;

    private final ImportClientAPI tcgApiClient;

    private final OnePieceDataService onePieceDataService;

    private static final int PAGE_SIZE = 100;


    public void updateOnePieceDatas(){

        try {
            onePieceDataService.saveAll(getAllCards());
        }catch (FeignException e){
            System.err.println("Feign error: " + e.status() + " - " + e.getMessage());
            throw e;
        }
    }



    public List<Card> getAllCards() {

        TcgApiResponse response = tcgApiClient.getAllOPCards(PAGE_SIZE, 1);
        List<Card> allCards = new ArrayList<>(inputAdapter.toEntityList(response.getData()));

        for (int page = 2; page <= response.getTotalPages(); page++) {
            TcgApiResponse pageResponse = tcgApiClient.getAllOPCards(PAGE_SIZE, page);
            allCards.addAll(inputAdapter.toEntityList(pageResponse.getData()));
        }

        return allCards;
    }
}
