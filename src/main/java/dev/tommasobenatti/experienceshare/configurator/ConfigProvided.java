package dev.tommasobenatti.experienceshare.configurator;

import dev.tommasobenatti.experienceshare.image.ImageHelper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigProvided implements WebMvcConfigurer {

    String myExternalFilePath = "file:" + ImageHelper.getRelativePart(); // end your path with a /

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(myExternalFilePath);
    }
}
