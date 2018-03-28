package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.book.Author;

import java.util.List;

public interface AuthorService {


    Author saveAuthor(Author author);

    void deleteAuthor(Author author);

    List getAuthors();

    Author getAuthorByName(String name);

    Author getAuthorById(Long id);

}
