package com.nardai.practice.visitors

import org.junit.Assert.assertEquals
import org.junit.Test


internal class VisitorServiceTest {


    @Test
    fun getList() {
        val service: VisitorService = VisitorService()
        val result = service.getDefaultList()

        assertEquals("Default name should be Rick", "Rick", result.get(0).name)
    }

}