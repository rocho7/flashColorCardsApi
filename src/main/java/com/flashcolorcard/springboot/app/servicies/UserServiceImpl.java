package com.flashcolorcard.springboot.app.servicies;

import com.flashcolorcard.springboot.app.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{


    @Autowired
    UserRespository respository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) respository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return respository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return respository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> isNewUser = findById(id);
        if ( isNewUser.isPresent() ) {
            User updatedUser = isNewUser.orElseThrow();
            updatedUser.setPassword(user.getPassword());
            return respository.save(updatedUser);
        }
        return null;
    }

    @Override
    public Optional<User> remove(Long id) {
        Optional<User> isUser = findById(id);
        if (isUser.isPresent()) {
            User removed = isUser.orElseThrow();
            respository.delete(removed);
            return isUser;
        }
        return Optional.empty();
    }
}
