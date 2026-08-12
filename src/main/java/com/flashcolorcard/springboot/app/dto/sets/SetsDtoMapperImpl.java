package com.flashcolorcard.springboot.app.dto.sets;

import com.flashcolorcard.springboot.app.entities.Sets;
import org.springframework.stereotype.Component;

@Component
public class SetsDtoMapperImpl implements SetsDtoMapper{
    @Override
    public Sets fromEntity(Sets entity) {

        if ( entity == null ) {
            return null;
        }
        return entity;
    }
}
