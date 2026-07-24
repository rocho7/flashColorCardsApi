package com.flashcolorcard.springboot.app.repositories;

import com.flashcolorcard.springboot.app.entities.Set;
import org.springframework.data.repository.CrudRepository;

public interface SetRepository extends CrudRepository<Set, Long>{
}
