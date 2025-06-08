package com.personal.tcgcollector.service;

import com.personal.tcgcollector.client.ImportClientAPI;
import com.personal.tcgcollector.common.mapping.TcgOnePieceInputAdapter;
import com.personal.tcgcollector.common.model.TcgApiResponse;
import com.personal.tcgcollector.persistence.entities.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OnePieceInputService {

    private final TcgOnePieceInputAdapter inputAdapter;

    private final ImportClientAPI tcgApiClient;

    private static final int PAGE_SIZE = 100;


    public void updateOnePieceDatas(){



    }



    public List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();

        TcgApiResponse response = tcgApiClient.getAllOPCards(1, PAGE_SIZE);
        allCards.addAll(inputAdapter.toEntityList(response.getData()));

        for (int page = 2; page <= response.getTotalPages(); page++) {
            TcgApiResponse pageResponse = tcgApiClient.getAllOPCards(page, PAGE_SIZE);
            allCards.addAll(inputAdapter.toEntityList(pageResponse.getData()));
        }

        return allCards;
    }
}
