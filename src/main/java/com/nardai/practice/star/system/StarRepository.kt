package com.nardai.practice.star.system

import com.nardai.practice.star.system.model.Star
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface StarRepository : CrudRepository<Star, Long> {

    override fun findAll(): List<Star>

    fun save(persisted: Star): Star

}