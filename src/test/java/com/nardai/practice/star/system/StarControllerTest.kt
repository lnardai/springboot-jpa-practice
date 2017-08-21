package com.nardai.practice.star.system

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@RunWith(SpringRunner::class)
@ContextConfiguration("classpath*:spring-root-context-test.xml")
@WebMvcTest
class StarControllerTest {

    @Autowired
    lateinit var mvc: MockMvc


    @Test
    @WithMockUser
    @Throws(Exception::class)
    fun getMockedUserData() {
        this.mvc.perform(MockMvcRequestBuilders.get("/v1/user/name")
                .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andExpect(MockMvcResultMatchers.content().string("user"))
    }

}
