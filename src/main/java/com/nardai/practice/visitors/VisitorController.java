package com.nardai.practice.visitors;

import com.nardai.practice.visitors.models.Visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/visitor")
public class VisitorController {

    @Autowired
    private VisitorService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Visitor> index() {
        return new ArrayList<>();
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void index(Visitor visitor) {
        service.addVisitor(visitor);
    }

}
