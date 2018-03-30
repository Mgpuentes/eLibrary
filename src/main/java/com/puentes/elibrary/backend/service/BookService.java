package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.backend.persistance.domain.book.Book;

import java.util.List;

public interface BookService {

    /**
     * Create book with the book instance given.
     *
     * @param book the book to save.
     * @return the persisted book
     */
    Book saveBook(Book book);

    /**
     * Delete given book.
     *
     * @param book book to be deleted.
     */
    void deleteBook(Book book);


    /**
     * Retrieve book by given isbn.
     *
     * @param isbn isbn used to retrieve book.
     * @return the book that matches the given isbn.
     */
    Book getBookByIsbn(Long isbn);

    /**
     * Retrieve book by title.
     *
     * @param title title used to retrieve book.
     * @return the book that matches given title.
     */
    Book getBookByTitle(String title);

    /**
     * Get list of all books.
     *
     * @return list of all books.
     */
    List<Book> getAllBooks();

    /**
     * Retrieves book by given id.
     *
     * @param id id used to retrieve book.
     * @return the book that matches given id.
     */
    Book getBookById(Long id);
}
