package com.pets.petsecommerce.service;

import com.pets.petsecommerce.model.entity.user.Role;
import com.pets.petsecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }


}
