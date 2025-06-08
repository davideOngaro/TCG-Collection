package com.personal.tcgcollector.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "004_LANGUAGES")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 5)
    private String code; // es: EN, JP, FR

    @Column(nullable = false)
    private String name; // es: English, Japanese

}
