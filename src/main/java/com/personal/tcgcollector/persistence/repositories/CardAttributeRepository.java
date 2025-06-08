package com.personal.tcgcollector.persistence.repositories;

import com.personal.tcgcollector.persistence.entities.CardAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardAttributeRepository extends JpaRepository<CardAttribute, String> {
}