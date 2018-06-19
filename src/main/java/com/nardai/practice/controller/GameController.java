package com.nardai.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/games")
public class GameController {

    @GetMapping("/game1")
    public ModelAndView getFirstGameData(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView("game1");
        mav.addObject("description", "First thing you need to do is go to...");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game2")
    public ModelAndView getSecondGameData(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        ModelAndView mav = new ModelAndView("game2");
        mav.addObject("description", "First thing you need to get is..");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

}
