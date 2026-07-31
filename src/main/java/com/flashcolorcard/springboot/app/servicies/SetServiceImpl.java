package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.Sets;
import com.flashcolorcard.springboot.app.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SetServiceImpl implements SetService{

    @Autowired
    private SetRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Sets> findAll() {
        return (List<Sets>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sets> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Sets save(Sets set) {
        return repository.save(set);
    }

    @Override
    public Sets update(Long id, Sets set) {
        Optional<Sets> isNewSet = findById(id);

        if ( isNewSet.isPresent() ) {
            Sets updatedSet = isNewSet.orElseThrow();
            updatedSet.setRemain(set.getRemain());
            updatedSet.setTotal(set.getTotal());
            updatedSet.setTitle(set.getTitle());
            updatedSet.setColor(set.getColor());
            return repository.save(updatedSet);
        }
        return null;
    }

    @Override
    public Optional<Sets> remove(Long id) {
        Optional<Sets> isSet = findById(id);

        if ( isSet.isPresent() ) {
            Sets removed = isSet.orElseThrow();

            repository.delete(removed);
            return isSet;
        }
        return Optional.empty();
    }
}
