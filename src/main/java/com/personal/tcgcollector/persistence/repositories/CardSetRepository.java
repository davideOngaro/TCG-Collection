package com.personal.tcgcollector.persistence.repositories;


import com.personal.tcgcollector.persistence.entities.CardSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardSetRepository extends JpaRepository<CardSet, Long> {

    @Query(value = "SELECT code FROM \"002_card_set\"", nativeQuery = true)
    List<String> findAllSetNames();

}



