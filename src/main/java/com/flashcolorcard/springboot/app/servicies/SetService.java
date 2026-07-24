package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.Set;

import java.util.List;
import java.util.Optional;

public interface SetService {


    List<Set> findAll();

    Optional<Set> findById(Long id);

    Set save(Set set);

    Set update(Long id, Set set);

    Optional<Set> remove(Long id);
}
