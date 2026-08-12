package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.dto.user.ResponseUserDto;
import com.flashcolorcard.springboot.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
//public interface UserRespository extends CrudRepository<User, Long> {
    public interface UserRespository extends JpaRepository<User, Long> {

        Optional<User> findByEmail(String email);
}
