package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.Set;
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
    public List<Set> findAll() {
        return (List<Set>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Set> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Set save(Set set) {
        return repository.save(set);
    }

    @Override
    public Set update(Long id, Set set) {
        Optional<Set> isNewSet = findById(id);

        if ( isNewSet.isPresent() ) {
            Set updatedSet = isNewSet.orElseThrow();
            updatedSet.setRemain(set.getRemain());
            updatedSet.setTotal(set.getTotal());
            updatedSet.setTitle(set.getTitle());
            updatedSet.setColor(set.getColor());
            return repository.save(updatedSet);
        }
        return null;
    }

    @Override
    public Optional<Set> remove(Long id) {
        Optional<Set> isSet = findById(id);

        if ( isSet.isPresent() ) {
            Set removed = isSet.orElseThrow();

            repository.delete(removed);
            return isSet;
        }
        return Optional.empty();
    }
}
