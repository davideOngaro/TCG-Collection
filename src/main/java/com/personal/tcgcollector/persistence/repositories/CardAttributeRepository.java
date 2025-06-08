package com.personal.tcgcollector.persistence.repositories;

import com.personal.tcgcollector.persistence.entities.CardAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardAttributeRepository extends JpaRepository<CardAttribute, String> {


    @Query(value = "SELECT name FROM \"005_attribute\"", nativeQuery = true)
    List<String> findAllAttributeNames();
}