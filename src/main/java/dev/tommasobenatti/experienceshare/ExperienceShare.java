package dev.tommasobenatti.experienceshare;

import dev.tommasobenatti.experienceshare.image.ImageHelper;

public class ExperienceShare {

    private static final ExperienceShare instance = new ExperienceShare();

    @Deprecated
    public void start() {
        logger("Checking if cache/ folder exits!");
        if (!ImageHelper.checkCacheFolder()) {
            logger("Cache folder doesn't exits, creating cache folder...");
        }
    }

    public static void logger(String message) {
        System.out.println("[ExperienceShare] " + message);
    }

    public static ExperienceShare getInstance() {
        return instance;
    }
}
