package com.flashcolorcard.springboot.app.dto.user;

import com.flashcolorcard.springboot.app.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDtoMapperImpl implements UserDtoMapper{
    @Override
    public List<ResponseUserDto> fromEntityList(List<User> users) {

        if (users.isEmpty()) {
            return null;
        }

        List<ResponseUserDto>  responseUserDtoList = new ArrayList<>();
        users.stream().forEach(user -> {
            ResponseUserDto responseUserDto = new ResponseUserDto();
            responseUserDto.setId(user.getId());
            responseUserDto.setName(user.getName());
            responseUserDto.setEmail(user.getEmail());
            responseUserDtoList.add(responseUserDto);

        });
        return responseUserDtoList;
    }
}
