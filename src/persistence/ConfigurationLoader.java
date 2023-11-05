package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {
    public static Configuration loadConfig(String configFile) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFile)) {
            properties.load(input);

            int scoreIncrement = Integer.parseInt(properties.getProperty("scoreIncrement"));
            int foodInterval = Integer.parseInt(properties.getProperty("foodInterval"));
            int obstacleInterval = Integer.parseInt(properties.getProperty("obstacleInterval"));
            int speedIncrementInterval = Integer.parseInt(properties.getProperty("speedIncrementInterval"));
            int initialSize = Integer.parseInt(properties.getProperty("initialSize"));;

            return new Configuration(scoreIncrement, foodInterval, obstacleInterval, speedIncrementInterval,initialSize);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
