package com.personal.tcgcollector.persistence.repositories;


import com.personal.tcgcollector.persistence.entities.CardSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardSetRepository extends JpaRepository<CardSet, Long> {
}

