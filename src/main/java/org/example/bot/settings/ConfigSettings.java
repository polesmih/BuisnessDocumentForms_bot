package org.example.bot.settings;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class ConfigSettings {
    private String token;
    private String userName;
    private String docPath;
    private Properties properties;
    public static final String FILE_NAME = "config.properties";
    private static ConfigSettings instance = new ConfigSettings();

    public static ConfigSettings getInstance() {
        return instance;
    }

    {
        try {
            properties = new Properties();

            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME)) {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new IOException(String.format("Error loading properties file '%s'", FILE_NAME));
            }

            token = properties.getProperty("token");
            if (token == null) {
                throw new RuntimeException("Token value is null");
            }

            userName = properties.getProperty("username");
            if (userName == null) {
                throw new RuntimeException("UserName value is null");
            }

            docPath = properties.getProperty("doc.path");
            if (docPath == null) {
                throw new RuntimeException("Doc path is null");
            }

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Bot initialisation error: " + e.getMessage());
        }
    }
}