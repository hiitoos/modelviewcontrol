package com.example.demomvc2.controllers;

import com.example.demomvc2.beans.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index{
    private final UserRepository userRepository;

    @Autowired
    public Index(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("mensaje","Hola mundo");
        return "index";
    }
}
