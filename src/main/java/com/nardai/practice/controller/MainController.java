package com.nardai.practice.controller;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nardai.practice.model.Exercise;
import com.nardai.practice.model.GameType;
import com.nardai.practice.model.SoulsStone;
import com.nardai.practice.repository.ExerciseRepository;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping({"/index", "/"})
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                            @RequestParam(name="actualGame", required=false, defaultValue = "FIRST") GameType selectedGame) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "laci");
        mav.addObject("actualGame", "");
        List<String> completed = new ArrayList<>();
        EnumSet.allOf(SoulsStone.class)
                .forEach(type -> {
                    List<Exercise> mindExercises = exerciseRepository.findAllByType(type);
                    calculatedCompleted(mindExercises, completed);
                });

        mav.addObject("completed", completed);

        return mav;
    }

    @GetMapping("/intro")
    public ModelAndView introController() {
        ModelAndView mav = new ModelAndView("intro");
        return mav;
    }

    private void calculatedCompleted(List<Exercise> exercises, List<String> completed){
        if(!exercises.isEmpty() && !findNotAnswered(exercises)){
            completed.add(exercises.get(0).getType().toString().toLowerCase());
        }
    }

    private boolean findNotAnswered(List<Exercise> exercises) {
        return exercises.stream().filter(e -> !e.getAnswered()).findAny().isPresent();
    }
}
