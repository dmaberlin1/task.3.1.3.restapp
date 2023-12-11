package com.dmadev.restapp.service;

import com.dmadev.restapp.exception.UserAlreadyExistException;
import com.dmadev.restapp.model.User;
import com.dmadev.restapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.findByFirstname(user.getFirstName()) !=null){
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
