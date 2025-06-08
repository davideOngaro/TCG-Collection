package com.personal.tcgcollector.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="001_CARD")
public class Card {

    @Id
    private String id; // es. OP02-001_p2

    private String code; // es. OP02-001
    private String name;
    private String rarity;
    private String type;
    private String imageSmall;
    private String imageLarge;

    private Integer cost;
    private Integer power;

    private String counter;
    private String color;

    private String family;


    private String ability;


    private String trigger;

    @ManyToOne
    @JoinColumn(name = "attribute_name", referencedColumnName = "name")
    private CardAttribute attribute;

    @ManyToOne
    @JoinColumn(name = "set_code")
    private CardSet set;
}
