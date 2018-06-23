package com.nardai.practice.controller.game;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nardai.practice.WrongAnswerException;

@Controller
@RequestMapping("/")
public class RealityController {

    @RequestMapping(value="/reality/answer/1", method=RequestMethod.POST)
    @ResponseBody
    public String getFirstGameData(@RequestParam(name="answer") String name) {
        if(name.equals("Laci")){
            return "success";
        } else{
            throw new WrongAnswerException("A valasz nem helyes");
        }
    }

}
