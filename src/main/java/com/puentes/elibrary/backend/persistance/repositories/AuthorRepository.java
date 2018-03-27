package com.puentes.elibrary.backend.persistance.repositories;

import com.puentes.elibrary.backend.persistance.domain.Author.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
