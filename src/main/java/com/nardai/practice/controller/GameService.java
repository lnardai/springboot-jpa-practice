package com.nardai.practice.controller;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nardai.practice.model.Exercise;
import com.nardai.practice.model.SoulsStone;
import com.nardai.practice.repository.ExerciseRepository;

@Component
public class GameService {

    @Autowired
    private ExerciseRepository exerciseRepository;


    public Map<String, Integer> getGameState(){
        Map<String, Integer> completed = new HashMap<>();
        EnumSet.allOf(SoulsStone.class)
                .forEach(type -> {
                    List<Exercise> mindExercises = exerciseRepository.findAllByType(type);
                    calculatedCompleted(mindExercises, completed);
                });

        return completed;
    }

    private void calculatedCompleted(List<Exercise> exercises, Map<String, Integer> completed){
        if(!exercises.isEmpty() && !findNotAnswered(exercises)){
            completed.put(exercises.get(0).getType().toString().toLowerCase(), exercises.get(0).getType().getValue());
        }
    }

    private boolean findNotAnswered(List<Exercise> exercises) {
        return exercises.stream().filter(e -> !e.getAnswered()).findAny().isPresent();
    }

}
