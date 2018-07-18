package com.nardai.practice.controller.game

import com.nardai.practice.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/")
class MindController constructor(@Autowired private val service : MindService) {

    @RequestMapping(value = "/mind/answer/{id}", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun getExactStar(@PathParam("id") id: Long, answer : String){
        return service.addAExercise(id, answer);
    }

    @RequestMapping(value = "/mind/questions", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllAnswers(): List<Exercise>{
        return service.findAllByType();
    }

}