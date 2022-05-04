package dev.tommasobenatti.experienceshare.properties;

import dev.tommasobenatti.experienceshare.Lang;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import static dev.tommasobenatti.experienceshare.ExperienceShare.logger;

public class PropertiesProvided {

    private static Properties prop = null;

    public static void init() {
        prop = new Properties();
        File file = new File("experienceshare.properties");
        if (!file.exists()) {
            logger("experienceshare.properties doesn't exits, create new!");
            for (Lang lang : Lang.values()) {
                prop.setProperty(lang.name().toLowerCase(), lang.getDefaultValue());
            }
            try {
                prop.store(new FileWriter("experienceshare.properties"), "ExperienceShare Properties");
            } catch (IOException e) {
                logger("Error on save experienceshare.properties");
                e.printStackTrace();
            }
        } else {
            try (FileReader reader = new FileReader("experienceshare.properties")) {
                logger("Loading experienceshare.properties");
                prop.load(reader);
            } catch (Exception e) {
                logger("Error on load experienceshare.properties");
                e.printStackTrace();
            }
        }
    }

    public static String getValue(String key) {
        if (prop == null)
            return "NoPropFile";

        return prop.getProperty(key, "NO-VALUE");
    }
}
