package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.Sets;

import java.util.List;
import java.util.Optional;

public interface SetService {


    List<Sets> findAll();

    Optional<Sets> findById(Long id);

    Sets save(Sets set);

    Sets update(Long id, Sets set);

    Optional<Sets> remove(Long id);
}
