package org.example.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabasePropertiesLoader implements PropertiesLoader {

    @Override
    public Properties loadProperties(String path) throws IOException {
        Properties properties = new Properties();

        try(InputStream input = new FileInputStream(new File(path))) {

            properties.load(input);

        }

        return properties;
    }
}
