package com.munaf.UserService.services;

import com.munaf.UserService.entities.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public User getUserById(Long userId);

    public List<User> getAllUsers();

    public String deleteUser(Long userId);

}
