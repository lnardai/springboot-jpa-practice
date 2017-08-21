package com.nardai.practice.visitors

import com.nardai.practice.visitors.models.Visitor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.InetAddress

@Service
class VisitorService{

    fun getDefaultList() : List<Visitor>{
        var result: MutableList<Visitor> = mutableListOf()
        result.add( Visitor(0,"Rick"))
        return result
    }

    fun addVisitor(visitor:  Visitor){
        //repository.add(visitor)
    }
}