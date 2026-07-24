package com.flashcolorcard.springboot.app.repositories;

import com.flashcolorcard.springboot.app.entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
