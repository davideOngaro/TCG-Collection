package com.personal.tcgcollector.common.mapping;

import com.personal.tcgcollector.common.model.CardDto;
import com.personal.tcgcollector.persistence.entities.Card;
import com.personal.tcgcollector.persistence.entities.CardAttribute;
import com.personal.tcgcollector.persistence.entities.CardSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TcgOnePieceInputAdapter {







    public List<Card> toEntityList(List<CardDto> dtos) {
        return dtos.stream().map(dto -> {
            CardAttribute attribute = null;
            if (dto.getAttribute() != null) {
                attribute = new CardAttribute(
                        dto.getAttribute().getName(),
                        dto.getAttribute().getImage()
                );
            }

            CardSet set = null;
            if (dto.getSet() != null) {
                set = new CardSet(dto.getCode().substring(0,dto.getCode().indexOf("-")),dto.getSet().getName(),null);
            }

            return new Card(
                    dto.getId(),
                    dto.getCode(),
                    dto.getRarity(),
                    dto.getType(),
                    dto.getName(),
                    dto.getImages().getSmall(),
                    dto.getImages().getLarge(),
                    dto.getCost(),
                    dto.getPower(),
                    dto.getCounter(),
                    dto.getColor(),
                    dto.getFamily(),
                    dto.getAbility(),
                    dto.getTrigger(),
                    attribute,
                    set
            );
        }).toList();
    }
}
