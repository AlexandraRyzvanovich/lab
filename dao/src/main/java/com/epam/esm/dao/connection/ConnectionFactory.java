package com.epam.esm.dao.connection;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PROPERTIES_FILE_PATH = "src/main/webapp/jdbc.properties";
    private static String url;
    private static String username;
    private static String password;

    public ConnectionFactory() {
        Path path = Paths.get(PROPERTIES_FILE_PATH);
        InputStream file;
        try {
            file = Files.newInputStream(path);
            Properties properties = new Properties();
            properties.load(file);
            url = (String) properties.get(URL);
            username = (String) properties.get(USERNAME);
            password = (String) properties.get(PASSWORD);
        } catch (IOException e) {

        }
    }

    public Connection create(ConnectionPool connectionPool) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return connection;
    }
}
