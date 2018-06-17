package com.nardai.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v1/user")
public class HelloController {

    @GetMapping("/index")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "laci");
        model.addAttribute("progress", Math.floor(Math.random() * 100));
        return "index";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye!";
    }

}
