package com.puentes.elibrary.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */

@Controller
public class HomeContoller {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
