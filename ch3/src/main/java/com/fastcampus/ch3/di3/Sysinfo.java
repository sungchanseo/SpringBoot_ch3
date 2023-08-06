package com.fastcampus.ch3.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("setting.properties")
public class Sysinfo {

    @Value("#{systemProperties['user.timezone']}")
    String timeZone;

    @Value("#{systemEnvironment['PWD']}")
    String currentDir;

    @Value("${autosaveDir}")
    String autosaveDir;

    @Value("${autosaveInterval}")
    int autosaveInterval;

    @Value("${autosave}")
    boolean autosave;

    @Override
    public String toString() {
        return "Sysinfo{" +
                "timeZone='" + timeZone + '\'' +
                ", currentDir='" + currentDir + '\'' +
                ", autosaveDir='" + autosaveDir + '\'' +
                ", autosaveInterval=" + autosaveInterval +
                ", autosave=" + autosave +
                '}';
    }
}
