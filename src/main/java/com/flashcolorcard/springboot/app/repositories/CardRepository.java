package com.flashcolorcard.springboot.app.repositories;

import com.flashcolorcard.springboot.app.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
