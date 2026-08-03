package com.flashcolorcard.springboot.app.controllers;

import com.flashcolorcard.springboot.app.dto.SetsDto;
import com.flashcolorcard.springboot.app.entities.Sets;
import com.flashcolorcard.springboot.app.servicies.SetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/set", produces = { "application/json" })
@Tag(name = "SetApi", description = "Operaciones relacionadas con sets")
public class SetController {

    @Autowired
    private SetService service;

    @GetMapping
    public ResponseEntity<List<Sets>> getAllSets() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener set by id", description = "Obtener un set por un especifico id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Set encontrado existosamente."),
                    @ApiResponse(responseCode = "400", description = "Set no encontrado."),
            }
    )
    public ResponseEntity<Sets> getSetById(@PathVariable Long id) {
        Optional<Sets> set = service.findById(id);
        if ( set.isPresent() ) {
            return ResponseEntity.ok(set.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sets> create(@RequestBody SetsDto set) {
        Sets setCreated = service.save(set);
        return ResponseEntity.status(HttpStatus.CREATED).body(setCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sets> update(@RequestBody Sets set, @PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, set));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Sets>> delete(@PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.remove(id));
    }
}
