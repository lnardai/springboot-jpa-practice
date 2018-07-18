package com.nardai.practice.repository

import com.nardai.practice.model.Setting
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SettingsRepository : CrudRepository<Setting, Long> {

    override fun findAll(): List<Setting>
    fun findByKey(key: String): List<Setting>
    fun save(persisted: Setting): Setting
}