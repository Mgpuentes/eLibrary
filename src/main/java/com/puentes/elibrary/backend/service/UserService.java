package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    /**
     * Create user with user instance given.
     *
     * @param user the user to save.
     * @return the persisted user.
     */
    User saveUser(User user);

    /**
     * Create user with specified parameters.
     *
     * @param user user to be created
     * @param userRoles user role assigned
     * @return persisted user
     */
    default User createUser(User user, Set<UserRole> userRoles) { return null; }

    /**
     * Delete user with user instance given.
     *
     * @param user user to be deleted.
     */
    void deleteUser(User user);

    /**
     * Retrieve user by given id.
     *
     * @param id id used to retrieve user.
     * @return the user that matches the given id.
     */
    User getUserById(Long id);


}
