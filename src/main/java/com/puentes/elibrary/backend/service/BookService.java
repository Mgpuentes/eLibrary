package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.book.Book;

public interface BookService {

    Book saveBook(Book book);

    void deleteBook(Book book);

    Book getBookByIsbn(Long isbn);

    Book getBookByTitle(String title);

}
