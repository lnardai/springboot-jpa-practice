package com.nardai.practice.authentication

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserContext {

    fun getUserName(): String {
        val details: Map<String, String> = getUserDetailsMap()
        return details.get("name").toString()
    }

    fun getUserId(): Long {
        val details: Map<String, String> = getUserDetailsMap()
        return details.get("id")!!.toLong()
    }

    private fun getUserDetailsMap(): Map<String, String> {
        val authentication = SecurityContextHolder.getContext().authentication as Authentication
        val details: Map<String, String> = authentication.details as Map<String, String>
        return details
    }
}