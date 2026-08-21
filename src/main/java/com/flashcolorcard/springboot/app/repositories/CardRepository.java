package com.flashcolorcard.springboot.app.repositories;

import com.flashcolorcard.springboot.app.entities.Card;
import com.flashcolorcard.springboot.app.entities.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByIdAndSet(Long idCard, Sets set);
}
