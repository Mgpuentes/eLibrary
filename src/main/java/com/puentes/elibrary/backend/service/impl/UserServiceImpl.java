package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;
import com.puentes.elibrary.backend.persistance.repositories.RoleRepository;
import com.puentes.elibrary.backend.persistance.repositories.UserRepository;
import com.puentes.elibrary.backend.service.UserService;
import com.puentes.elibrary.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Set;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    @Override
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {

        validateInputs(user, userRoles);

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            LOG.warn("User already exist as {}. Nothing will be done!", existingUser);
        } else {

            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }

            user.setPassword(SecurityUtils.passwordEncoder().encode(user.getPassword()));
            user.getUserRoles().addAll(userRoles);
            existingUser = userRepository.save(user);
        }


        return existingUser;

    }

    private void validateInputs(Object ... objects) throws IllegalArgumentException {

        for (Object object : objects) {
            if (object == null || (object instanceof String && StringUtils.isEmpty((String) object))) {
                throw new IllegalArgumentException("No null elements or empty strings allowed!");
            }
        }
    }
}
