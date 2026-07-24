package com.flashcolorcard.springboot.app.controllers;

import com.flashcolorcard.springboot.app.entities.Card;
import com.flashcolorcard.springboot.app.servicies.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/card", produces = { "application/json" })
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        Optional<Card> card = service.findById(id);
        if (card.isPresent()) {
            return ResponseEntity.ok(card.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card card) {
        Card cardCreated = service.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@RequestBody Card card, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, card));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Card>> delete(@PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.remove(id));
    }
}
