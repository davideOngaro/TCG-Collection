package com.personal.tcgcollector.persistence.repositories;

import com.personal.tcgcollector.persistence.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,String> {
}
