package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.Card;
import com.flashcolorcard.springboot.app.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository respository;

    @Transactional(readOnly = true)
    @Override
    public List<Card> findAll() {
        return (List<Card>) this.respository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Card> findById(Long id) {
        return respository.findById(id);
    }

    @Transactional
    @Override
    public Card save(Card card) {
         return respository.save(card);
    }

    @Override
    public Card update(Long id, Card card) {

        Optional<Card> isNewCard = this.findById(id);
        if (isNewCard.isPresent()) {
            Card updatedCard = isNewCard.orElseThrow();
            updatedCard.setTitle(card.getTitle());
            updatedCard.setReview(card.getReview());
            updatedCard.setForgotten(card.getForgotten());
            updatedCard.setDate(LocalDate.now());
            updatedCard.setAnswer(card.getAnswer());
            updatedCard.setDelay(card.getDelay());
            updatedCard.setColor(card.getColor());
            return respository.save(updatedCard);
        }
        return null;
    }

    @Transactional
    @Override
    public Optional<Card> remove(Long id) {
        Optional<Card> isCard = findById(id);
        if ( isCard.isPresent()) {
            Card removed = isCard.orElseThrow();
             respository.delete(removed);
            return isCard;
        }
        return Optional.empty();
    }
}
