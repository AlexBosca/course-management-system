package org.example.loader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DatabasePropertiesLoaderTest {

    private final DatabasePropertiesLoader databasePropertiesLoader = new DatabasePropertiesLoader();
    private final Properties properties = new Properties();
//    private final static String

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void loadPropertiesSuccessfully() {
        properties.setProperty("database.url", "jdbc:mysql://localhost:3306/course_management_system");
        properties.setProperty("database.username", "root");
        properties.setProperty("database.password", "123456789a");

        assertDoesNotThrow(() -> assertEquals(properties, databasePropertiesLoader.loadProperties("src/main/resources/org/example/config.properties")));
    }

    @Test
    void loadPropertiesThrowsIOExceptionNonExistentFile() {
        assertThrows(IOException.class, () -> databasePropertiesLoader.loadProperties("non-existent/path"));
    }

    @Test
    void loadPropertiesThrowsNullPointerExceptionNullPathname() {
        assertThrows(NullPointerException.class, () -> databasePropertiesLoader.loadProperties(null));
    }
}