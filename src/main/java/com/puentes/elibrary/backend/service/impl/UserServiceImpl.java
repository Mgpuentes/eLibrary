package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.User.User;
import com.puentes.elibrary.backend.persistance.repositories.UserRepository;
import com.puentes.elibrary.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
