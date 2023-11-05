package model;

import persistence.Configuration;
import persistence.ConfigurationLoader;
import presenter.Presenter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class GameBoard {
    private int width;
    private int height;
    private Snake snake;
    private Food food;
    private Barrier barrier;
    private Move move;
    private Score score;
    private Presenter presenter;
    private boolean firstTime;
    private int scoreIncrement;
    private int foodInterval;
    private int obstacleInterval;
    private int speedIncrementInterval;
    private int initialSize;

    public GameBoard(int width, int height, Presenter presenter) {
        configData();
        this.presenter = presenter;
        this.width = width;
        this.height = height;
        firstTime = true;
        snake = new Snake(width / 2, height / 2,initialSize, width,height);
        move = new Move(this, snake, speedIncrementInterval);
        food = new Food(this, foodInterval, width, height);
        barrier = new Barrier(obstacleInterval, width, height);
        score = new Score(this);
    }

    public void startGame() {
        move.start();
        food.start();
        barrier.start();
        score.start();
    }
    public void configData(){
        Configuration config = ConfigurationLoader.loadConfig("data/config.properties");
        if (config != null) {
            scoreIncrement = config.getScoreIncrement();
            foodInterval = config.getFoodInterval();
            obstacleInterval = config.getObstacleInterval();
            speedIncrementInterval = config.getSpeedIncrementInterval();
            initialSize = config.getInitialSize();
        }else{
            System.out.println("documento no encontrado");
        }
    }
    public void  stopGame()throws InterruptedException{
        move.interrupt();
        score.interrupt();
        food.interrupt();
        barrier.interrupt();
    }
    public void resetGame()  {
        snake = new Snake(width / 2, height / 2,initialSize, width,height);
        move = new Move(this, snake, speedIncrementInterval);
        food = new Food(this, foodInterval, width, height);
        barrier = new Barrier(obstacleInterval, width, height);
        score = new Score(this);
        move.start();
        food.start();
        barrier.start();
        score.start();
    }

    public Object[][] loadScores() {
        ArrayList<Score> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/scores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String date = parts[0];
                    String playerName = parts[1];
                    int scoreValue = Integer.parseInt(parts[2]);

                    if (isValidScore(date, playerName, scoreValue)) {
                        Score score = new Score(this);
                        score.setDate(date);
                        score.setPlayerName(playerName);
                        score.setScore(scoreValue);
                        scores.add(score);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el historial de puntuaciones: " + e.getMessage());
        }

        Object[][] scoreArray = new Object[scores.size()][];
        for (int i = 0; i < scores.size(); i++) {
            scoreArray[i] = scores.get(i).toObjectArray();
        }

        return scoreArray;
    }

    private boolean isValidScore(String date, String playerName, int score) {
        return !date.isEmpty() && !playerName.isEmpty() && score >= 0;
    }
    public boolean eat() {
        Point head = snake.getBody().getFirst();
        if (head.equals(new Point(food.getX(), food.getY()))) {
            snake.grow();
            food.generateNewFood();
            System.out.println(score.getScore());
            return true;
        }
        return false;
    }



    public boolean collideFood() {
        Point head = snake.getBody().getFirst();
        if (head.equals(new Point(food.getX(), food.getY()))) {
                return true;
        }
        return false;
    }

    public boolean collisionBarrier() {
        Point head = snake.getBody().getFirst();
        return barrier.isBarrier(head.x, head.y);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public Barrier getBarrier() {
        return barrier;
    }
    public boolean getFirstTime(){
        return firstTime;
    }

    public Score getScore() {
        return score;
    }

    public Move getMove() {
        return move;
    }
    public int incrementScore(){
        return scoreIncrement * ((int) (Math.random() * 10));
    }

    public int getScoreValue() {
        return score.getScore();
    }


}
