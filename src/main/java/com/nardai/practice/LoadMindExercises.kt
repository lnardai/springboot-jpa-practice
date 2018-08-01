package com.nardai.practice

import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import com.nardai.practice.repository.ExerciseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct


@Configuration
open class LoadMindExercises constructor(@Autowired private val exerciseRepository : ExerciseRepository) {

    @PostConstruct
    open fun loadMind() {
        val list : MutableList<Exercise> = ArrayList()
        list.add(
                Exercise(
                question = "Mi a nyero lepes az alabbi kepen?",
                correctAnswer = "e4-e5",
                type = SoulsStone.MIND ))

        list.forEach{e -> exerciseRepository.save(e)}
    }
}