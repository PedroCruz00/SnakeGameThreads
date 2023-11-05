package model;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Food extends Thread {
    private int x;
    private int y;
    int maxX;
    int maxY;
    private boolean active;
    private GameBoard gameBoard;
    private int timeOccurrence;


    public Food(GameBoard gameBoard, int timeOccurrence, int maxX, int maxY) {
        this.timeOccurrence = timeOccurrence;
        this.gameBoard = gameBoard;
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

        if (gameBoard.collideFood()) {
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
                sleep(timeOccurrence);
            } catch (InterruptedException e) {
                System.out.println("Food thread interrupted");
            }
            active = false;
        }
    }
}
