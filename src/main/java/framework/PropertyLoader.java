package framework;

import java.util.Objects;
import java.util.Properties;

public class PropertyLoader {

    private static final Properties configProperties = new Properties();

    static {
        loadConfigProperties();
    }

    public static String getProperty(String key) {
        return configProperties.getProperty(key);
    }

    private static void loadConfigProperties() {


        try {
            configProperties.load(ClassLoader.getSystemResource("config.test.properties").openStream());
        } catch (Exception e) {
            try {
                configProperties.load(ClassLoader.getSystemResource("config.properties").openStream());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    protected static String retrieveProperty(String key) {
        String result = System.getenv(key);
        if (Objects.isNull(result)) {
            result = System.getProperty(key, PropertyLoader.getProperty(key));
        }
        return result;
    }
}
