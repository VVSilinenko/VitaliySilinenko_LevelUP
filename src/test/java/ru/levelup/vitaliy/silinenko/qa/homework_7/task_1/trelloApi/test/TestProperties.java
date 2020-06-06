package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import java.io.IOException;
import java.util.Properties;

class TestProperties {

    String getValue(String prop){
        Properties authProperties = new java.util.Properties();
        try {
            authProperties.load(this.getClass().getClassLoader().getResourceAsStream("auth.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authProperties.getProperty(prop);
    }
}
