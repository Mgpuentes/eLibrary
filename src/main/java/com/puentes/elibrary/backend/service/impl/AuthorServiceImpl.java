package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.book.Author;
import com.puentes.elibrary.backend.persistance.repositories.AuthorRepository;
import com.puentes.elibrary.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Service
public class AuthorServiceImpl  implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Create the author with the instance given.
     *
     * @param author the author to save
     * @return
     */
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Delete author with given author instance.
     *
     * @param author author to be deleted.
     */
    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    /**
     * Retrieve list of all authors.
     *
     * @return
     */
    @Override
    public List getAuthors() {
        return null;
    }

    @Override
    public Author getAuthorByName(String name) {
        return null;
    }

    /**
     * Retrieves the author with the given id.
     *
     * @param id the id used to retrieve author.
     * @return the author that matches given id.
     */
    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
