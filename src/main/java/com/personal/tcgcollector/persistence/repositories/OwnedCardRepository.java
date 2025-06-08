package com.personal.tcgcollector.persistence.repositories;

import com.personal.tcgcollector.persistence.entities.OwnedCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnedCardRepository extends JpaRepository<OwnedCard,String> {
}
