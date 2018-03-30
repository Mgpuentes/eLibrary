package com.puentes.elibrary.web.controllers;

import com.puentes.elibrary.backend.persistance.domain.book.Book;
import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;
import com.puentes.elibrary.backend.persistance.repositories.RoleRepository;
import com.puentes.elibrary.backend.service.BookService;
import com.puentes.elibrary.backend.service.UserService;
import com.puentes.elibrary.enums.RolesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Slf4j
@Controller
public class HomeContoller {

        @Autowired
        BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }


}
