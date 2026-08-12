package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.dto.UserDto;
import com.flashcolorcard.springboot.app.dto.user.ResponseUserDto;
import com.flashcolorcard.springboot.app.dto.user.UserDtoMapper;
import com.flashcolorcard.springboot.app.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDtoMapper mapper;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    UserRespository respository;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResponseUserDto> findAll() {
        List<User> users = respository.findAll();

        List<ResponseUserDto> responseUserDtos = mapper.fromEntityList(users);


        return responseUserDtos;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return respository.findById(id);
    }

    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        if(Objects.isNull(userDto)) {
            System.out.println("No found user "+ userDto);
            return null;
        }
        if(findByEmail(userDto.getEmail())){

            System.out.println("User already exists "+ userDto);
            return null;

        } else {
            User createdUser = new User();
            createdUser.setName(userDto.getName());
            createdUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            createdUser.setEmail(userDto.getEmail());
            User userSaved = respository.save(createdUser);
            userDto.setId(userSaved.getId());
            userDto.setPassword("********");
            return userDto;
        }
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> isNewUser = findById(id);
        if ( isNewUser.isPresent() ) {
            User updatedUser = isNewUser.orElseThrow();
            updatedUser.setPassword(user.getPassword());
            return respository.save(updatedUser);
        }
        return null;
    }

    @Override
    public Optional<User> remove(Long id) {
        Optional<User> isUser = findById(id);
        if (isUser.isPresent()) {
            User removed = isUser.orElseThrow();
            respository.delete(removed);
            return isUser;
        }
        return Optional.empty();
    }

    public boolean findByEmail(String username) {
        Optional<User> byUsername = respository.findByEmail(username);
        if (byUsername.isPresent()) {
            return true;
        }
        return false;
    }
}
