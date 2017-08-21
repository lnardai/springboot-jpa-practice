package com.nardai.practice.star.system.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Star(@Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long,
                   val name: String = "C1",
                   val type: StarType)



enum class StarType {
    BROWN_DWARF,
    RED_DWARF,
    ORANGE,
    YELLOW,
    WHITE
}