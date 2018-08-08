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
                        question = "Mit mond az alabbi jelenetben pontosan Palpatine Senator?",
                        imageUrl= "/images/palpatine-senator.png",
                        hint= "Ekezetek nem szamitanak!",
                        correctAnswer = "es meg soha, soha nem voltam ilyen eltokelt",
                        type = SoulsStone.MIND ))
        list.add(
                Exercise(
                question = "Nyero 2 lepesbol, mik helyes lepesek? Valaszt vesszovel elvalasztva add meg.",
                hint= "Chess notation: https://en.wikipedia.org/wiki/Chess_notation",
                imageUrl= "/images/chess-problem.png",
                correctAnswer = "Qxh7,Rg8#",
                type = SoulsStone.MIND ))

        list.forEach{e -> exerciseRepository.save(e)}
    }
}