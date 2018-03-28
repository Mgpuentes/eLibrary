package com.puentes.elibrary.backend.persistance.repositories;

import com.puentes.elibrary.backend.persistance.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
