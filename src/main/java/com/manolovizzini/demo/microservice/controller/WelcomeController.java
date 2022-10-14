package com.manolovizzini.demo.microservice.controller;

import com.manolovizzini.demo.microservice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Controller
public class WelcomeController {

    private final UserService userService;

    @Autowired
    public WelcomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        String titleEntities = "Users";
        String title = "Microservice: "+titleEntities;
        model.addAttribute("title", title);
        model.addAttribute("titleEntities", titleEntities);
        model.addAttribute("users", userService.findAll());
        return "index";
    }
}
