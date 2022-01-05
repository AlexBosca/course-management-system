package org.example.loader;

import java.io.IOException;
import java.util.Properties;

public interface PropertiesLoader {
    String CONFIGURATION_FILE_PATH = "src/main/resources/org/example/config.properties";

    Properties loadProperties(String path) throws IOException;
}
