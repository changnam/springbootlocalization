package com.honsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
    
    @GetMapping("/")
    public String helloPage() {
        return "hello";
    }
    
    @GetMapping("/{name}") // <--- 1
    public String hello(@PathVariable String name, Model model) { // <--- 2
        model.addAttribute("name", name); // <--- 3

        return "hello"; // <--- 4
    }
}