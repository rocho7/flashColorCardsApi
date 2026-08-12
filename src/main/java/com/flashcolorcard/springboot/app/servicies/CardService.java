package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.dto.CardDto;
import com.flashcolorcard.springboot.app.entities.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {

    List<Card> findAll();

    Optional<Card> findById(Long id);

    Card save(CardDto card);

    Card update(Long id, Card card);

    Optional<Card> remove(Long id);


}
