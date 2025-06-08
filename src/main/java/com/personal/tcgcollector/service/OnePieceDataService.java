package com.personal.tcgcollector.service;


import com.personal.tcgcollector.persistence.entities.Card;
import com.personal.tcgcollector.persistence.entities.CardAttribute;
import com.personal.tcgcollector.persistence.entities.CardSet;
import com.personal.tcgcollector.persistence.repositories.CardAttributeRepository;
import com.personal.tcgcollector.persistence.repositories.CardRepository;
import com.personal.tcgcollector.persistence.repositories.CardSetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OnePieceDataService {

    private final CardRepository cardRepository;

    private final CardAttributeRepository cardAttributeRepository;

    private final CardSetRepository cardSetRepository;



    public void saveAll(List<Card> allCards){
        List<String> registeredAttributes = cardAttributeRepository.findAllAttributeNames();
        List<String> registeredCardSet = cardSetRepository.findAllSetNames();
        List<String> registeredCard = cardRepository.findAllCardIds();

        List<CardAttribute> newAttributes = new ArrayList<>();
        List<CardSet> newCardSet = new ArrayList<>();
        List<Card> newCards = new ArrayList<>();
        for (Card card : allCards){

            CardAttribute attribute = card.getAttribute();
            if (attribute != null && attribute.getName() != null && !registeredAttributes.contains(attribute.getName())) {
                newAttributes.add(attribute);
            }


            CardSet set = card.getSet();
            if (set != null && set.getCode() != null && !registeredCardSet.contains(set.getCode())) {
                newCardSet.add(set);
            }

            if(!registeredCard.contains(card.getCode())){
                newCards.add(card);
            }

        }

        cardAttributeRepository.saveAll(newAttributes);
        cardSetRepository.saveAll(newCardSet);

        Map<String, CardAttribute> managedAttributes = cardAttributeRepository.findAll().stream()
                .collect(Collectors.toMap(CardAttribute::getName, a -> a));
        Map<String, CardSet> managedSets = cardSetRepository.findAll().stream()
                .collect(Collectors.toMap(CardSet::getCode, s -> s));

        for (Card card : newCards) {
            card.setAttribute(managedAttributes.get(card.getAttribute().getName()));
            card.setSet(managedSets.get(card.getSet().getCode()));
        }
        cardRepository.saveAll(newCards);
    }

}
