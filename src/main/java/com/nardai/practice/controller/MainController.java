package com.nardai.practice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nardai.practice.model.GameType;
import com.nardai.practice.model.SoulsStone;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping({"/index", "/"})
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                            @RequestParam(name="actualGame", required=false, defaultValue = "FIRST") GameType selectedGame) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "laci");
        mav.addObject("actualGame", "");
        List<String> completed = new ArrayList<>();
        completed.add(SoulsStone.TIME.toString().toLowerCase());
        completed.add(SoulsStone.MIND.toString().toLowerCase());
        mav.addObject("completed", completed);

        return mav;
    }

    @GetMapping("/intro")
    public ModelAndView introController() {
        ModelAndView mav = new ModelAndView("intro");
        return mav;
    }
}
