package com.flashcolorcard.springboot.app.dto.sets;

import com.flashcolorcard.springboot.app.entities.Sets;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring", uses = {})
public interface SetsDtoMapper {

    Sets fromEntity(Sets entity);
}
