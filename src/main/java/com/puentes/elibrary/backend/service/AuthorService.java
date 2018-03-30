package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.book.Author;

import java.util.List;

public interface AuthorService {


    /**
     * Create author with author instance given.
     *
     * @param author the author to save
     * @return the persisted author
     */
    Author saveAuthor(Author author);

    /**
     *  Delete given author
     *
     * @param author author to be deleted.
     */
    void deleteAuthor(Author author);

    /**
     * Get a list of authors.
     *
     * @return list of authors
     */
    List getAuthors();

    /**
     *  Get author by author name.
     *
     * @param name the name of the author to be retrieved.
     * @return the author that matches name given
     */
    Author getAuthorByName(String name);

    /**
     * Get author by given id.
     *
     * @param id the id used to retrieve author.
     * @return the author that matches given id.
     */
    Author getAuthorById(Long id);

}
