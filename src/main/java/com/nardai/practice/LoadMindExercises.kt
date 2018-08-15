package com.nardai.practice

import com.nardai.practice.model.Exercise
import com.nardai.practice.model.ExerciseType
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
                        question = "Mit mond az alábbi jelenetben pontosan Palpatine szenátor?",
                        imageUrl= "/images/palpatine-senator.png",
                        hint= "motiváció",
                        correctAnswer = "és még soha, soha nem voltam ilyen eltökélt",
                        type = SoulsStone.MIND ))
        list.add(
                Exercise(
                question = "Nyerő 2 lépésből, mik helyes lépések? Választ vesszővel elválasztva add meg.",
                hint= "Chess notation: https://en.wikipedia.org/wiki/Chess_notation",
                imageUrl= "/images/chess-problem.png",
                correctAnswer = "Qxh7,Rg8#",
                type = SoulsStone.MIND ))

        list.add(
                Exercise(
                        question = "Menjünk el együtt egy múzeumba/kiállításra ahol még sosem jártunk'",
                        exerciseType = ExerciseType.QUEST,
                        hint= "Én vezetek!",
                        correctAnswer = "Csúszdapark",
                        type = SoulsStone.MIND ))

        list.add(
                Exercise(
                        question = "Egy fehérvári étteremben elrejtetem egy QR kódot. Naponta egyet találhatsz. " +
                                "Ha kitalálod elviszlek oda, és meglelheted a kódot.",
                        exerciseType = ExerciseType.FIND_QR,
                        hint = "Nem a bEat",
                        correctAnswer = "Hókuszpók",
                        type = SoulsStone.MIND ))

        list.add(
                Exercise(
                        question = "Mutass nekem egy parametrikus modellt amit Te készítettél!",
                        exerciseType = ExerciseType.QUEST,
                        hint= "Find the Laszlo --> Kiss the Laszlo --> Program gets Installed",
                        correctAnswer = "Karalábé",
                        type = SoulsStone.MIND ))


        if(exerciseRepository.findAll().isEmpty()){
            list.forEach{e -> exerciseRepository.save(e)}
        }
    }
}