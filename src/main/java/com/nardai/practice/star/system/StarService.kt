package com.nardai.practice.star.system

import com.nardai.practice.star.system.model.Star
import com.nardai.practice.star.system.model.StarType
import org.springframework.stereotype.Component
import java.util.*


@Component
class StarService{

    fun getRandomStar() : Star {
        val r = Random()
        return Star(r.nextLong(), UUID.randomUUID().toString(), StarType.BROWN_DWARF)
    }

}