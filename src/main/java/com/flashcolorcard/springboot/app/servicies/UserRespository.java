package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Long> {
}
