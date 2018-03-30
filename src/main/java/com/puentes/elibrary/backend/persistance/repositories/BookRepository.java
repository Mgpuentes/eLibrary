package com.puentes.elibrary.backend.persistance.repositories;

import com.puentes.elibrary.backend.persistance.domain.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface BookRepository extends CrudRepository<Book, Long> {

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    @Override
    List<Book> findAll();
}
