package com.nardai.practice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Exercise(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long = 0,
                val question: String = "N/A",
                val imageUrl: String = "",
                val correctAnswer: String = "N/A",
                var providedAnswer: String = "No answer provided",
                var answered: Boolean = false,
                val type: SoulsStone,
                val hint: String = "N/A")

