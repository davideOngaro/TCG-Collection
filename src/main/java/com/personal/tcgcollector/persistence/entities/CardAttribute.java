package com.personal.tcgcollector.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="005_ATTRIBUTE")
public class CardAttribute {

    @Id
    private String name; // es. Special, Slash, Ranged

    private String imageUrl;
}