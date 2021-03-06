package com.nardai.practice.controller.game

import com.nardai.practice.controller.WrongAnswerException
import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import com.nardai.practice.repository.ExerciseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class GameExerciseService constructor(@Autowired private val exerciseRepository : ExerciseRepository){

    fun addAExercise(id: Long, answer: String) : Exercise {
        var exercise: Exercise = exerciseRepository.findById(id).get()
        if(exercise.correctAnswer.equals(answer)){
            exercise.providedAnswer = answer
            exercise.answered = true
            exerciseRepository.save(exercise)
            return exercise;
        } else{
            throw WrongAnswerException("Answer did not match")
        }
    }

    fun getAllAnswers() : List<Exercise> {
        return exerciseRepository.findAll()
    }

    fun findAllByType(type : SoulsStone) : List<Exercise> {
        return exerciseRepository.findAllByType(type)
    }
}