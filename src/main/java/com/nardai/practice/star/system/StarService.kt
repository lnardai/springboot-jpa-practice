package com.nardai.practice.star.system

import com.nardai.practice.star.system.model.Star
import com.nardai.practice.star.system.model.StarType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


@Component
class StarService (@Autowired private val starRepository : StarRepository){


    fun addRandomStar(){
        starRepository.save(generateRandom())
    }

    fun getRandomStar() : Star {
        return generateRandom()
    }

    private fun generateRandom() : Star {
        val r = Random()
        return Star(r.nextLong(), UUID.randomUUID().toString(), StarType.BROWN_DWARF)
    }

    fun getAllStars(): List<Star> {
        return starRepository.findAll()
    }

    fun getStar(id : Long): Star {
        return starRepository.findById(id).get()
    }

}