package core.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public final class PropertiesController {

    private static Properties properties = null;
    private static InputStream input = null;

    public static String getProperty(String propertyName) {
        if (Objects.isNull(properties)) {
            properties = new Properties();
            try {
                input = PropertiesController.class.getClassLoader().getResourceAsStream(getPropertyFile());
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return properties.getProperty(propertyName);
    }

    private static String getPropertyFile() {
        return "properties/" + Optional.ofNullable(System.getProperty(PropertiesNames.ENV_CONFIG_FILE))
                .orElse("chromebooking.properties");
    }
}
