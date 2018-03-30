package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.book.Book;
import com.puentes.elibrary.backend.persistance.repositories.BookRepository;
import com.puentes.elibrary.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Create book with book instance given.
     *
     * @param book the book to save.
     * @return persisted book.
     */
    @Override
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Delete book by book instance given.
     *
     * @param book book to be deleted.
     */
    @Override
    @Transactional
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    /**
     * Retrieve book by given isbn.
     *
     * @param isbn isbn used to retrieve book.
     * @return the book that matches given isbn.
     */
    @Override
    public Book getBookByIsbn(Long isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    /**
     * Retrieve book by given title.
     *
     * @param title title used to retrieve book.
     * @return the book that matches given title.
     */
    @Override
    public Book getBookByTitle(String title) {
        return null;
    }

    /**
     * Retrieve list of all books.
     *
     * @return list of all books.
     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves book by given id.
     *
     * @param id id used to retrieve book.
     * @return the book that matches given id.
     */
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
