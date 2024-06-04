package com.pets.petsecommerce.security;

import com.pets.petsecommerce.model.entity.user.User;
import com.pets.petsecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userService.findByUsernameOrEmail(username, username);

        if (u == null) {
            throw new UsernameNotFoundException("Usuario nao cadastrado!");
        }

        Set<SimpleGrantedAuthority> authorities = u.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username, u.getPassword(), authorities);

    }
}
