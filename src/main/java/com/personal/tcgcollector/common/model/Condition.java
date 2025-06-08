package com.personal.tcgcollector.common.model;

public enum Condition {
    MINT,           // Perfetta, come nuova
    NEAR_MINT,      // Quasi perfetta, impercettibili difetti
    EXCELLENT,      // Leggeri segni di usura
    GOOD,           // Usura visibile ma carta integra
    LIGHT_PLAYED,   // Giocata leggermente
    PLAYED,         // Giocata pesantemente
    DAMAGED         // Danneggiata (pieghe, strappi, ecc.)
}