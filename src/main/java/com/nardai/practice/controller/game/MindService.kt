package com.nardai.practice.controller.game

import com.nardai.practice.model.Answer
import com.nardai.practice.repository.MindAnswerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class MindService @Autowired constructor(private val mindAnswerRepository : MindAnswerRepository){


    fun addAnswer(answer: Answer){
        mindAnswerRepository.save(answer)
    }

    fun getAllAnswers() : List<Answer> {
        return mindAnswerRepository.findAll()
    }

}