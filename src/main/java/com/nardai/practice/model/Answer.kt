package com.nardai.practice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Answer(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long,
                val text: String = "N/A")

