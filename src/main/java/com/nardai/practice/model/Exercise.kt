package com.nardai.practice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Exercise(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0,
                    var question: String = "N/A",
                    val imageUrl: String = "",
                    @JsonIgnore val correctAnswer: String = "N/A",
                    var providedAnswer: String = "No answer provided",
                    var answered: Boolean = false,
                    val type: SoulsStone,
                    val exerciseType: ExerciseType = ExerciseType.ANSWER,
                    val hint: String = "N/A")

