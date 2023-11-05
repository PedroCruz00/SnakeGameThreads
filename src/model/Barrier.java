package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barrier extends Thread {
    private List<Point> barriers;
    private int rangeTime;
    private int maxX;
    private int maxY;
    private boolean active;
    private boolean gameOver;
    private int x ;
    private int y ;

    public Barrier(int range, int maxX, int maxY) {
        barriers = new ArrayList<>();
        this.rangeTime = range;
        this.maxX = maxX;
        this.maxY = maxY;
        this.active = false;
        this.gameOver = false;
    }

    public boolean GameOver(){
        return gameOver;
    }

    public boolean isBarrier(int x, int y) {
        Point point = new Point(x, y);
        return barriers.contains(point);
    }

    private void generateBarriers() {
        Random random = new Random();
        x = random.nextInt(maxX + 1);
        y = random.nextInt(maxY + 1);
        Point barrier = new Point(x, y);
        barriers.add(barrier);
    }

    @Override
    public void run() {
        while (true) {
            if (!active) {
                generateBarriers();
            }
            try {
                sleep(rangeTime);
            } catch (InterruptedException e) {
                System.out.println("Barrier thread interrupted");
            }

            active = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
