package com.nardai.practice.controller.game

import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import com.nardai.practice.repository.MindAnswerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class MindService constructor(@Autowired private val mindAnswerRepository : MindAnswerRepository){

    fun addAExercise(id: Long, answer: String){
        var exercise: Exercise = mindAnswerRepository.findById(id).get()
        if(exercise.correctAnswer.equals(answer)){
            exercise.providedAnswer = answer;
        }
        mindAnswerRepository.save(exercise)
    }

    fun getAllAnswers() : List<Exercise> {
        return mindAnswerRepository.findAll()
    }

    fun findAllByType() : List<Exercise> {
        return mindAnswerRepository.findAllByType(SoulsStone.MIND)
    }
}