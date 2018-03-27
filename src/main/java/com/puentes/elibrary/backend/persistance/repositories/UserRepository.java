package com.puentes.elibrary.backend.persistance.repositories;

import com.puentes.elibrary.backend.persistance.domain.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
