package com.nardai.practice.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nardai.practice.model.Setting;
import com.nardai.practice.service.SettingsService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @RequestMapping(value="/{settingsKey}", method=RequestMethod.GET)
    @ResponseBody
    public boolean getSetting(@PathParam("settingsKey") String key) {
        return Boolean.parseBoolean(settingsService.getSettingByName(key).getText());
    }

    @RequestMapping(value="/assign/{settingsKey}/{settingsValue}", method=RequestMethod.POST)
    @ResponseBody
    public void setSetting(@PathVariable("settingsKey") String key, @PathVariable("settingsValue") String value) {
        settingsService.setSettings(new Setting(key, value));
    }

    @RequestMapping(value="/play-intro", method=RequestMethod.GET)
    @ResponseBody
    public boolean playIntro() {
        Setting setting = settingsService.getSettingByName("play-intro");
        if( setting == null ){
            return true;
        }
        return Boolean.parseBoolean(setting.getText());
    }

}
