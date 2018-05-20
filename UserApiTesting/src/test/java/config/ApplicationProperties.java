package config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sabin on 5/20/2018.
 */
@Slf4j
public class ApplicationProperties extends Properties {

    public ApplicationProperties() {

        Properties systemProperties = System.getProperties();
        String envName = systemProperties.getProperty("config.env");

        String propertiesFileName = envName != null ? String.format("application-%s.properties", envName) : "application.properties";

        try {
            InputStream properties = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName);
            this.load(properties);
        } catch (IOException e) {
            log.error("Error occured in ApplicationProperties.class", e.getMessage());
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }
}
