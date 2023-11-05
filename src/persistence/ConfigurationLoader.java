package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {
        public static Configuration loadConfig(String configFile,String level) {
            Properties properties = new Properties();
            try (FileInputStream input = new FileInputStream(configFile)) {
                properties.load(input);

                int scoreIncrement = Integer.parseInt(properties.getProperty("level."+level+".scoreIncrement"));
                int foodInterval = Integer.parseInt(properties.getProperty("level."+level+".foodInterval"));
                int obstacleInterval = Integer.parseInt(properties.getProperty("level."+level+".obstacleInterval"));
                int speedIncrementInterval = Integer.parseInt(properties.getProperty("level."+level+".speedIncrementInterval"));
                int initialSize = Integer.parseInt(properties.getProperty("level."+level+".initialSize"));

                return new Configuration(scoreIncrement, foodInterval, obstacleInterval, speedIncrementInterval, initialSize);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
}
