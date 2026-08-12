package com.flashcolorcard.springboot.app.dto.user;

import com.flashcolorcard.springboot.app.entities.User;

import java.util.List;

public interface UserDtoMapper {

    List<ResponseUserDto> fromEntityList(List<User> users);
}
