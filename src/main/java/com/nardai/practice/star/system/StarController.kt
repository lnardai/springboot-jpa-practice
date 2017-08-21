package com.nardai.practice.star.system

import com.nardai.practice.star.system.model.Star
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/stars")
class StarController @Autowired constructor(private val service : StarService){


    @GetMapping("/random")
    fun getRandomStar() : Star {
        return service.getRandomStar()
    }
}
