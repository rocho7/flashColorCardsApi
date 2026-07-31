package com.flashcolorcard.springboot.app.repositories;

import com.flashcolorcard.springboot.app.entities.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SetRepository extends JpaRepository<Sets, Long> {
}
