package com.munaf.UserService.services.impl;

import com.munaf.UserService.entities.User;
import com.munaf.UserService.exceptions.ResourceAlreadyExistsException;
import com.munaf.UserService.exceptions.ResourceNotFoundException;
import com.munaf.UserService.repositories.UserRepository;
import com.munaf.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new ResourceAlreadyExistsException("Email Already Exists");
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id" + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "Deleted";
    }
}
