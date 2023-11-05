package persistence;

public class Configuration {
    private int scoreIncrement;
    private int foodInterval;
    private int obstacleInterval;
    private int initialSize;
    private int speedIncrementInterval;

    public Configuration(int scoreIncrement, int foodInterval, int obstacleInterval, int speedIncrementInterval, int initialSize) {
        this.scoreIncrement = scoreIncrement;
        this.foodInterval = foodInterval;
        this.obstacleInterval = obstacleInterval;
        this.speedIncrementInterval = speedIncrementInterval;
        this.initialSize = initialSize;
    }

    public int getScoreIncrement() {
        return scoreIncrement;
    }

    public int getFoodInterval() {
        return foodInterval;
    }

    public int getObstacleInterval() {
        return obstacleInterval;
    }

    public int getSpeedIncrementInterval() {
        return speedIncrementInterval;
    }

    public void setScoreIncrement(int scoreIncrement) {
        this.scoreIncrement = scoreIncrement;
    }

    public void setFoodInterval(int foodInterval) {
        this.foodInterval = foodInterval;
    }

    public void setObstacleInterval(int obstacleInterval) {
        this.obstacleInterval = obstacleInterval;
    }

    public void setSpeedIncrementInterval(int speedIncrementInterval) {
        this.speedIncrementInterval = speedIncrementInterval;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }
}