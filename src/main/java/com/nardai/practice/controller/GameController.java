package com.nardai.practice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nardai.practice.model.SoulsStone;
import com.nardai.practice.service.SettingsService;

@Controller
@RequestMapping("/")
public class GameController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping("/game1")
    public ModelAndView getMindGameData() {
        ModelAndView mav = new ModelAndView("game1");
        mav.addObject("actualGame", SoulsStone.MIND);
        mav.addObject("description", "This is the first game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game2")
    public ModelAndView getSpaceGameData() {
        ModelAndView mav = new ModelAndView("game2");
        mav.addObject("actualGame", SoulsStone.SPACE);
        mav.addObject("description", "This is the second game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game3")
    public ModelAndView getPowerGameData() {
        ModelAndView mav = new ModelAndView("game3");
        mav.addObject("actualGame", SoulsStone.POWER);
        mav.addObject("description", "This is the second game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game4")
    public ModelAndView getRealityGameData(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView("game4");
        mav.addObject("actualGame", SoulsStone.REALITY);
        mav.addObject("description", "This is the second game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game5")
    public ModelAndView getTimeGameData(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView("game5");
        mav.addObject("actualGame", SoulsStone.TIME);
        mav.addObject("description", "This is the second game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @GetMapping("/game6")
    public ModelAndView getSecondGameData(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView("game6");
        mav.addObject("actualGame", SoulsStone.SOUL);
        mav.addObject("description", "This is the second game");
        mav.addObject("progress", Math.floor(Math.random() * 100));
        return mav;
    }

    @RequestMapping(value="/api/gamestate", method=RequestMethod.GET)
    @ResponseBody
    public List<String> getGameState() {
        List<String> completed = new ArrayList<>();
        completed.add(SoulsStone.TIME.toString().toLowerCase());
        completed.add(SoulsStone.MIND.toString().toLowerCase());
        return completed;
    }
}
