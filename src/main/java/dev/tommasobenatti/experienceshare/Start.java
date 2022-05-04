package dev.tommasobenatti.experienceshare;

import dev.tommasobenatti.experienceshare.properties.PropertiesProvided;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        PropertiesProvided.init();
        System.getProperties().put("server.port", Lang.PORT.getValue());
        SpringApplication.run(Start.class, args);

        ExperienceShare.getInstance().start();
        ExperienceShare.logger("ExperienceShare started on " + Lang.DOMAIN.getValue() + ":" + Lang.PORT.getValue());
    }
}
