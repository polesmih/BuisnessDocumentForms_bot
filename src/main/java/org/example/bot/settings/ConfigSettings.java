package org.example.bot.settings;

import lombok.Data;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class ConfigSettings {
    public static final String FILE_NAME = "config.properties";
    private static ConfigSettings instance = new ConfigSettings();
    private Properties properties;
    private String token;
    private String userName;
    private String dbDriver;
    private String dbSchema;
    private String dbRoot;
    private String dbPassword;

    private TelegramBotsApi telegramBotsApi;

    public static ConfigSettings getInstance() {
        return instance;
    }

    {
        try {
            properties = new Properties();

            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME)){
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

            dbDriver = properties.getProperty("db_driver");
            if (dbDriver == null) {
                throw new RuntimeException("DbDriver value is null");
            }

            dbSchema = properties.getProperty("db_schema");
            if (dbSchema == null) {
                throw new RuntimeException("DbSchema value is null");
            }

            dbRoot = properties.getProperty("db_root");
            if (dbRoot == null) {
                throw new RuntimeException("DbRoot value is null");
            }

            dbPassword = properties.getProperty("db_password");
            if (dbPassword == null) {
                throw new RuntimeException("DbPassword value is null");
            }

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Bot initialisation error: " + e.getMessage());
        }
    }

}
