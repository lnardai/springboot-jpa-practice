package com.nardai.practice.visitors

import com.nardai.practice.visitors.models.Visitor
import java.net.InetAddress

class VisitorService() {
    fun add(name : String, ip : InetAddress) {
        println("Hello, ${name}")
    }

    fun getList() : List<Visitor>{
        var result: MutableList<Visitor> = mutableListOf()
        result.add( Visitor())
        return result
    }
}