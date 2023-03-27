package org.example.bot.settings;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class ConfigSettings {
    private String botToken;
    private String botName;
    private String docPath;
    private String jsonPath;
    private Properties properties;
    private static volatile ConfigSettings instance;
    private static final String FILE_NAME = "config.properties";

    private ConfigSettings() {
    }

    public static ConfigSettings getInstance() {
        if (instance == null) {
            synchronized (ConfigSettings.class) {
                if (instance == null) {
                    instance = new ConfigSettings();
                }
            }
        }
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

            botToken = properties.getProperty("token");
            if (botToken == null) {
                throw new RuntimeException("Token value is null");
            }

            botName = properties.getProperty("username");
            if (botName == null) {
                throw new RuntimeException("UserName value is null");
            }

            docPath = properties.getProperty("doc.path");
            if (docPath == null) {
                throw new RuntimeException("Doc path is null");
            }

            jsonPath = properties.getProperty("json.path");
            if (jsonPath == null) {
                throw new RuntimeException("Json path is null");
            }

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Bot initialisation error: " + e.getMessage());
        }
    }
}