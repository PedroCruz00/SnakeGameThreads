package model;

import java.util.Random;

public class Food extends Thread {
    private int x;
    private int y;
    int maxX ;
    int maxY ;
    private boolean active;
    private Snake snake;
    private int timeOcurrence;

    public Food(Snake snake, int timeOcurrence, int maxX, int maxY) {
        this.snake = snake;
        this.timeOcurrence = timeOcurrence;
        this.active = false;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    public void generateNewFood() {
        Random random = new Random();
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);

        if (snake.collideFood()) {
            generateNewFood();
        }

        active = true;
    }

    @Override
    public void run() {
        while (true) {
            if (!active) {
                generateNewFood();
            }

            try {
                sleep(timeOcurrence);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            active = false;
        }
    }
}
