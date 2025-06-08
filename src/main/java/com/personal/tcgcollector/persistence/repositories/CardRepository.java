package com.personal.tcgcollector.persistence.repositories;


import com.personal.tcgcollector.persistence.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}