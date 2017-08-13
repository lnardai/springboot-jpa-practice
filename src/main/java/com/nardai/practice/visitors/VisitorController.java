package com.nardai.practice.visitors;

import com.nardai.practice.visitors.models.Visitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/visitor")
public class VisitorController {

    @RequestMapping("/list")
    public List<Visitor> index() {
        return new ArrayList<>();
    }
}
