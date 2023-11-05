package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move extends Thread implements KeyListener {
    private Snake snake;
    private int speed;
    private boolean running;
    private boolean gameOver;
    private GameBoard gameBoard;
    private Object gameOverLock;

    public Move(GameBoard gameBoard, Snake snake, int speed) {
        this.snake = snake;
        this.gameBoard = gameBoard;
        gameOverLock  = new Object();
        this.speed = speed;
        this.running = true;
        this.gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void moveSnake() {
        while (running) {
            synchronized (gameOverLock) {
                if (gameOver) {
                    break;
                }
            }
            snake.move();
            if (gameBoard.collisionBarrier() || snake.collideSelf()) {
                running = false;
                gameOver = true;
                if (gameOver){
                    gameBoard.gameOver();
                }
            }
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Move thread interrupted");
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
        if (e.getKeyCode() == KeyEvent.VK_W && snake.getDirection() != Direction.DOWN) {
            snake.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S && snake.getDirection() != Direction.UP) {
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_A && snake.getDirection() != Direction.RIGHT) {
            snake.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D && snake.getDirection() != Direction.LEFT) {
            snake.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

