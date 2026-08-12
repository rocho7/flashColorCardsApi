package com.flashcolorcard.springboot.app.dto.card;

import com.flashcolorcard.springboot.app.entities.Card;
import org.springframework.stereotype.Component;

@Component
public class CardDtoMapperImpl implements CardDtoMapper{

    @Override
    public Card fromEntity(Card entity) {

        if ( entity == null ) {
            return null;
        }
        return entity;
    }
}
