package com.personal.tcgcollector.persistence.repositories;


import com.personal.tcgcollector.persistence.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    @Query(value = "SELECT id FROM \"001_card\"", nativeQuery = true)
    List<String> findAllCardIds();
}