package com.nardai.practice.controller.game

import com.nardai.practice.model.Answer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MindController @Autowired constructor(private val service : MindService) {

    @RequestMapping(value = "/mind/answer/1", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun getExactStar(answer : String){
        return service.addAnswer(Answer(0, answer));
    }

    @RequestMapping(value = "/mind/answer/1", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllAnswers(): List<Answer>{
        return service.getAllAnswers();
    }

}