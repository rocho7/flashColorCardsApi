package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    User update(Long id, User user);

    Optional<User> remove(Long id);
}
