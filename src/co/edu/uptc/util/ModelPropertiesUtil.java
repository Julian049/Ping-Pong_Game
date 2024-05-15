package co.edu.uptc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ModelPropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/ModelConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
