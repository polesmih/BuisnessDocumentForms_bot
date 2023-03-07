package org.example.db;

import org.example.bot.settings.ConfigSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static Connection dbConnection;

    private final static ConfigSettings settings = ConfigSettings.getInstance();

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(settings.getDbDriver());

        dbConnection = DriverManager.getConnection(settings.getDbSchema(),
                settings.getDbRoot(), settings.getDbPassword());

        return dbConnection;
    }


}
