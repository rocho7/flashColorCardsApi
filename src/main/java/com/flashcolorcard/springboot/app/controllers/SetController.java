package com.flashcolorcard.springboot.app.controllers;

import com.flashcolorcard.springboot.app.entities.Set;
import com.flashcolorcard.springboot.app.servicies.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/set", produces = { "application/json" })
public class SetController {

    @Autowired
    private SetService service;

    @GetMapping
    public ResponseEntity<List<Set>> getAllSets() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Set> getSetById(@PathVariable Long id) {
        Optional<Set> set = service.findById(id);
        if ( set.isPresent() ) {
            return ResponseEntity.ok(set.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Set> create(@RequestBody Set set) {
        Set setCreated = service.save(set);
        return ResponseEntity.status(HttpStatus.CREATED).body(setCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Set> update(@RequestBody Set set, @PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, set));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Set>> delete(@PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.remove(id));
    }
}
