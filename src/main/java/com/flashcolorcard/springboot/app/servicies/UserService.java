package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.dto.UserDto;
import com.flashcolorcard.springboot.app.dto.user.ResponseUserDto;
import com.flashcolorcard.springboot.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<ResponseUserDto> findAll();

    Optional<User> findById(Long id);

    UserDto save(UserDto user);

    User update(Long id, User user);

    Optional<User> remove(Long id);
}
