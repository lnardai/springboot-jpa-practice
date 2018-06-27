package com.nardai.practice.repository

import com.nardai.practice.model.Answer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MindAnswerRepository : CrudRepository<Answer, Long> {

    override fun findAll(): List<Answer>

    fun save(persisted: Answer): Answer
}