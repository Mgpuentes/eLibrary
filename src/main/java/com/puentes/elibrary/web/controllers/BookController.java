package com.puentes.elibrary.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Controller
public class BookController {

    @GetMapping("/add")
    public String addBook() {
        return "add_book";
    }
}
