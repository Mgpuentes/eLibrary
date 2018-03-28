package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    User saveUser(User user);

    default User createUser(User user, Set<UserRole> userRoles) { return null; }

    void deleteUser(User user);

    User getUserById(Long id);


}
