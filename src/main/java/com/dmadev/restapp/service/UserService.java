package com.dmadev.restapp.service;

import com.dmadev.restapp.exception.UserAlreadyExistException;
import com.dmadev.restapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user) throws UserAlreadyExistException;

    void deleteUser(Long id);

    User getUserById(Long id);

}
