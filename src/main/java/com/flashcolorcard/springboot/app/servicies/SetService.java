package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.dto.SetsDto;
import com.flashcolorcard.springboot.app.entities.Sets;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Optional;

public interface SetService {


    List<Sets> findAll();

    List<Sets> findByUserId(HttpHeaders headers);

    Optional<Sets> findById(Long id);

    Sets save(SetsDto set);

    Sets update(Long id, Sets set);

    Optional<Sets> remove(Long id);
}
