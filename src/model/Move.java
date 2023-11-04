package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move extends Thread implements KeyListener {
    private Snake snake;
    private int speed;
    private boolean running;
    private boolean gameOver;

    public Move(Snake snake, int speed) {
        this.snake = snake;
        this.speed = speed;
        this.running = true;
        this.gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void moveSnake() {
        while (running) {
            snake.move();
            if (snake.collisionBarrier() || snake.collideSelf()) {
                running = false;
                gameOver = true;
            }
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        moveSnake();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
            snake.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
            snake.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
            snake.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
