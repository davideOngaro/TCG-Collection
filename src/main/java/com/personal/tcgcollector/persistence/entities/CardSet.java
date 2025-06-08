package com.personal.tcgcollector.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="002_CARD_SET")
public class CardSet {

    @Id
    private String code; // es: OP01, ST01, P

    private String name;

    @OneToMany(mappedBy = "set")
    private List<Card> cards;
}