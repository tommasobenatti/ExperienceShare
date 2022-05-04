package dev.tommasobenatti.experienceshare;

import dev.tommasobenatti.experienceshare.properties.PropertiesProvided;
import lombok.Getter;

import java.beans.ConstructorProperties;

public enum Lang {

    API_KEY("PUT_YOUR_API_KEY_HERE"), //This can be anything you want
    TITLE("Powered by FiatLinUX 🚗🐧"),
    DOMAIN("https://PUT_YOUR_DOMAIN_HERE"),
    DESCRIPTION("File uploader by Tommaso"),
    COLOR("#55FFFF"),
    PORT("8080");





    @Getter
    private final String defaultValue;

    public String getValue() {
        return PropertiesProvided.getValue(this.name().toLowerCase());
    }

    @ConstructorProperties({"defaultValue"})
    Lang(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
