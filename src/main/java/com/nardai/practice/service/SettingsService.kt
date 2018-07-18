package com.nardai.practice.service

import com.nardai.practice.model.Setting
import com.nardai.practice.repository.SettingsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class SettingsService (@Autowired private val settingsRepository: SettingsRepository){


    fun setSettings(setting: Setting){
        settingsRepository.save(setting)
    }

    fun getSettingByName(key: String) : Setting? {
        return settingsRepository.findByKey(key).firstOrNull();
    }

}