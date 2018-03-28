package com.puentes.elibrary.backend.service.impl;

import com.puentes.elibrary.backend.persistance.domain.book.Book;
import com.puentes.elibrary.backend.persistance.repositories.BookRepository;
import com.puentes.elibrary.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getBookByIsbn(Long isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    @Override
    public Book getBookByTitle(String title) {
        return null;
    }
}
