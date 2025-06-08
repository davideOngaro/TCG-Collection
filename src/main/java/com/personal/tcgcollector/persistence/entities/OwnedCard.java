package com.personal.tcgcollector.persistence.entities;

import com.personal.tcgcollector.common.model.Condition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="003_OWNED_CARD")
public class OwnedCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userId;

    private int quantity = 1;

    @ManyToOne
    @JoinColumn(name = "language_code", referencedColumnName = "code")
    private Language language; // opzionale: EN, JP...

    private Condition condition; // opzionale: NM, EX...

    private boolean foil = false;

    @ManyToOne
    private Card card;
}