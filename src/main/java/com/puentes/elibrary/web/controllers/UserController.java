package com.puentes.elibrary.web.controllers;

import com.puentes.elibrary.backend.persistance.domain.security.User;
import com.puentes.elibrary.backend.persistance.domain.security.UserRole;
import com.puentes.elibrary.backend.persistance.repositories.RoleRepository;
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
import java.util.Set;

/**
 * Created by Matthew on 3/28/2018.
 *
 * @author Matthew
 */

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    /**
     * Load user object to front through model
     */
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("signUpUser", new User());
        return "user";
    }

    @PostMapping(value = "/signup")
    public String signupPost(@ModelAttribute("signUpUser") User user) {
        LOG.info("User info received is {}", user);
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, roleRepository.findById(RolesEnum.USER.getId()).orElse(null)));
        userService.createUser(user, userRoles);

        return "redirect:/user";
    }

    @GetMapping("/login")
    public String signin() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
