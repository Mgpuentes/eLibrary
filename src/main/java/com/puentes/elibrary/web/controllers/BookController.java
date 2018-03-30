package com.puentes.elibrary.web.controllers;

import com.puentes.elibrary.backend.persistance.domain.book.Book;
import com.puentes.elibrary.backend.service.BookService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("bookAdded", new Book());
        return "addbook";
    }

    @PostMapping("/addingbook")
    public String addbook(@ModelAttribute("bookAdded") Book book) {
        bookService.saveBook(book);
        return"redirect:/profile";

    }


    @GetMapping("/delete")
    public String bookToDelete(@RequestParam("isbn") String isbn) {
        bookService.deleteBook(bookService.getBookById(Long.valueOf(isbn)));
        return"redirect:/";

    }

    @GetMapping("/updateBook")
    public String update(@RequestParam("isbn") String isbn, Model model) {
        model.addAttribute("book", bookService.getBookById(Long.valueOf(isbn)));
        return"updatebook";

    }

    @PostMapping("/updateBook")
    public String update(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return"redirect:/";

    }

}
