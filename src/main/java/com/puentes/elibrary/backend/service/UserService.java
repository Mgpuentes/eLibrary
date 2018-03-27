package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.User.User;

public interface UserService {

    User saveUser(User user);

    void deleteUser(User user);

    User getUserById(Long id);


}
