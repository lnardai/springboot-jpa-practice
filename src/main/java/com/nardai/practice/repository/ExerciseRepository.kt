package com.nardai.practice.repository

import com.nardai.practice.model.Exercise
import com.nardai.practice.model.SoulsStone
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExerciseRepository : CrudRepository<Exercise, Long> {

    override fun findAll(): List<Exercise>

    override fun findById(id: Long?): Optional<Exercise>

    fun findAllByType(type: SoulsStone): List<Exercise>

    fun save(persisted: Exercise): Exercise
}