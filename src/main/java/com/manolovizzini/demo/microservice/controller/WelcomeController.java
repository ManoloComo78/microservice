package com.manolovizzini.demo.microservice.controller;

import com.manolovizzini.demo.microservice.dto.UserMapper;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import com.manolovizzini.demo.microservice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Controller
public class WelcomeController {

    private final UserService userService;

    private final UserMapper userMapper;

    @Autowired
    public WelcomeController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        String titleEntities = "Users";
        String title = "Microservice: "+titleEntities;

        model.addAttribute("title", title);
        model.addAttribute("titleEntities", titleEntities);
        model.addAttribute("users", userMapper.usersToUserDTOs(userService.findAll()));
        return "index";
    }
}
