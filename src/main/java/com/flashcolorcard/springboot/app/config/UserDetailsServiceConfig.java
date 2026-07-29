package com.flashcolorcard.springboot.app.config;

import com.flashcolorcard.springboot.app.entities.User;
import com.flashcolorcard.springboot.app.servicies.UserRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRespository userRepository) {
        return username -> {
            Optional<User> user = userRepository.findByEmail(username);
            if (!user.isPresent()) {
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
        };
    }
}
