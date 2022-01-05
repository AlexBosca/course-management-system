package org.example.database;

import org.example.loader.DatabasePropertiesLoader;
import org.example.loader.PropertiesLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection databaseConnection;
    private Properties databaseProperties;
    private static volatile Database databaseInstance;

    private Database() {
        try {
            loadDatabaseConfigurationProperties();
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.databaseConnection = DriverManager.getConnection(
                    databaseProperties.getProperty("database.url"),
                    databaseProperties.getProperty("database.username"),
                    databaseProperties.getProperty("database.password"));
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Cannot find class Driver in package com.mysql.cj.jdbc", e);
        } catch (SQLException e) {
            if(databaseProperties.getProperty("url") != null) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "A database access error just occurred", e);
            } else {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Database url is null", e);
            }
        } catch (IOException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Cannot load database configuration properties", e);
        }
    }

    private void loadDatabaseConfigurationProperties() throws IOException {
        this.databaseProperties = new DatabasePropertiesLoader().loadProperties(PropertiesLoader.CONFIGURATION_FILE_PATH);
    }

    public static Database getDatabaseInstance() {
        Database result = databaseInstance;

        if(result != null) {
            return result;
        }
        synchronized (Database.class) {
            if(databaseInstance == null) {
                databaseInstance = new Database();
            }

            return databaseInstance;
        }
    }

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }
}
