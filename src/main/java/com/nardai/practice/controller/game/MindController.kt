package com.nardai.practice.controller.game

import com.nardai.practice.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class MindController constructor(@Autowired private val service : MindService) {

    @RequestMapping(value = "/mind/answer/{id}", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun getExactStar(@PathVariable("id") id: Long, answer : String) : Exercise{
        return service.addAExercise(id, answer);
    }

    @RequestMapping(value = "/mind/questions", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllAnswers(): List<Exercise>{
        return service.findAllByType();
    }

}