package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barrier extends Thread {
    private List<Point> barreras;
    private int rangeTime;
    private int maxX;
    private int maxY;
    private boolean running;
    private boolean gameOver;

    public Barrier(int range, int maxX, int maxY) {
        barreras = new ArrayList<>();
        this.rangeTime = range;
        this.maxX = maxX;
        this.maxY = maxY;
        this.running = true;
        this.gameOver = false;
    }

    public boolean GameOver() {
        return gameOver;
    }

    public boolean isBarrier(int x, int y) {
        Point point = new Point(x, y);
        return barreras.contains(point);
    }

    private void generateBarriers() {
        Random random = new Random();
        while (running) {
            int x = random.nextInt(maxX + 1);
            int y = random.nextInt(maxY + 1);
            Point barrera = new Point(x, y);
            barreras.add(barrera);

            try {
                sleep(rangeTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        generateBarriers();
    }
}