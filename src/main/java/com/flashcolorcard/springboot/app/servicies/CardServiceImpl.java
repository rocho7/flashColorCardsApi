package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.commom.commonutils.HttpError;
import com.flashcolorcard.springboot.app.dto.CardDto;
import com.flashcolorcard.springboot.app.dto.card.CardDtoMapper;
import com.flashcolorcard.springboot.app.entities.Card;
import com.flashcolorcard.springboot.app.entities.Sets;
import com.flashcolorcard.springboot.app.exceptions.ResourceNotFoundException;
import com.flashcolorcard.springboot.app.repositories.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository respository;

    @Autowired
    private CardDtoMapper mapper;

    @Autowired
    private SetService setService;

    @Transactional(readOnly = true)
    @Override
    public List<Card> findAll( ) {
        return (List<Card>) this.respository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Card> findById(Long id) {
        return respository.findById(id);
    }

    @Override
    public Optional<Card> getByIdAndByIdSet(Long idCard, Sets set) {
        return respository.findByIdAndSet(idCard, set);
    }

    @Transactional
    @Override
    public Card save(CardDto cardDto) {

        Card newCard = new Card();
        if ( cardDto.getIdSet() != null  ) {
            Optional<Sets> sets = setService.findById(cardDto.getIdSet());
            if (sets.isEmpty()) {
                log.info("No existe Set con ese id {} " + cardDto.getIdSet());
                List<HttpError> errors = new ArrayList<>();
                errors.add(
                        new HttpError("", "set", "", "No existe Set con ese id desde service "+cardDto.getIdSet())
                );
                throw new ResourceNotFoundException("ResourceNotFoundException no encontrado id " +cardDto.getIdSet(), errors);
            }else {
                Sets set = new Sets();
                set.setId(sets.get().getId());

                newCard.setColor(cardDto.getColor());
                newCard.setReview(cardDto.getReview());
                newCard.setDate(LocalDate.now());
                newCard.setForgotten(cardDto.getForgotten());
                newCard.setAnswer(cardDto.getAnswer());
                newCard.setDelay(null);
                newCard.setTitle(cardDto.getTitle());
                newCard.setSet(set);
            }
        }

        return respository.save(newCard);
    }

    @Override
    public Card update(Long id, Card card) {

//        Optional<Card> isNewCard = this.findById(id);
        Optional<Card> isNewCard = this.getByIdAndByIdSet(id, card.getSet());
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
