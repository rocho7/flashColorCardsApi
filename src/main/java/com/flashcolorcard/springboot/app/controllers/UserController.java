package com.flashcolorcard.springboot.app.controllers;

import com.flashcolorcard.springboot.app.dto.UserDto;
import com.flashcolorcard.springboot.app.dto.user.ResponseUserDto;
import com.flashcolorcard.springboot.app.entities.User;
import com.flashcolorcard.springboot.app.servicies.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<List<ResponseUserDto>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{email}")
    @Operation(summary = "Obtener user by email", description = "Obtener un user por un especifico email.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Set encontrado existosamente."),
                    @ApiResponse(responseCode = "400", description = "Set no encontrado."),
            }
    )
    public ResponseEntity<Optional<ResponseUserDto>> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findUserByEmail(email));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto user) {
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

    @GetMapping("/logged")
    public ResponseEntity<UserDto> getLoggedUser(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(service.getLoguedUser(headers), HttpStatus.OK);
    }
}
