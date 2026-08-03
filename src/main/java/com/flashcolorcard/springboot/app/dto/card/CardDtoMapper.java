package com.flashcolorcard.springboot.app.dto.card;

import com.flashcolorcard.springboot.app.entities.Card;

public interface CardDtoMapper {

    Card fromEntity(Card entity);
}
