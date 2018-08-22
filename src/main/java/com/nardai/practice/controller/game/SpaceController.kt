package com.nardai.practice.controller.game

import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/space")
class SpaceController constructor(@Autowired private val service : GameExerciseService) {

    @RequestMapping(value = "/answer/{id}", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun getExactStar(@PathVariable("id") id: Long, answer : String) : Exercise{
        return service.addAExercise(id, answer);
    }

    @RequestMapping(value = "/questions", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllAnswers(): List<Exercise>{
        return service.findAllByType(SoulsStone.SPACE);
    }

}