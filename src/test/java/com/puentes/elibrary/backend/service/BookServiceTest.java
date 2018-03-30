package com.puentes.elibrary.backend.service;

import com.puentes.elibrary.ElibraryApplication;
import com.puentes.elibrary.backend.persistance.domain.book.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElibraryApplication.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Rule
    public TestName testName;

    @Before
    public void setUp() throws Exception {
        testName = new TestName();
        assertNotNull(bookService);
    }

    @Test
    @Transactional
    public void saveBook() {
        Long isbnTest = 3409l;
        Book book = new Book();
        book.setTitle(testName.getMethodName() + "title");
        book.setIsbn(isbnTest);

        Book saveBook = bookService.saveBook(book);
        assertNotNull(saveBook);
        assertNotNull(saveBook.getId());

        assertEquals(saveBook, book);
    }

    @Test
    @Transactional
    public void deleteBook() {
        Long isbnTest = 3409L;
        Book book = new Book();
        book.setTitle(testName.getMethodName() + "title");
        book.setIsbn(isbnTest);

        Book bookSaved = bookService.saveBook(book);

        assertNotNull(bookSaved);
        assertNotNull(bookSaved.getId());

        assertNotNull(bookService.getBookById(bookSaved.getId()));

        bookService.deleteBook(bookSaved);

        Book returned = bookService.getBookById(bookSaved.getId());
        assertNull(returned);
    }

    @Test
    public void getBookByIsbn() {
    }

    @Test
    public void getBookByTitle() {
    }

    @Test
    public void getAllBooks() {
    }
}