package com.nardai.practice

import com.nardai.practice.controller.game.MindService
import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import com.nardai.practice.repository.MindAnswerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct


@Configuration
open class LoadMindExercises constructor(@Autowired private val mindAnswerRepository : MindAnswerRepository) {

    @PostConstruct
    open fun loadMind() {
        val list : MutableList<Exercise> = ArrayList()
        list.add(
                Exercise(
                question = "Mi a nyero lepes az alabbi kepen?",
                correctAnswer = "e4-e5",
                type = SoulsStone.MIND ))

        list.forEach{e -> mindAnswerRepository.save(e)}
    }
}