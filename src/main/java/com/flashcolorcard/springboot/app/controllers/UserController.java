package com.flashcolorcard.springboot.app.controllers;

import com.flashcolorcard.springboot.app.dto.UserDto;
import com.flashcolorcard.springboot.app.entities.User;
import com.flashcolorcard.springboot.app.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/auth", produces = {"application/json"})
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        UserDto userCreated = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<User>> delete(@PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.remove(id));
    }
}
