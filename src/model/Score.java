package model;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Score extends Thread {
    private int score;
    private String date;
    private String playerName;
    private GameBoard gameBoard;

    public Score(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.score = 0;
    }
    public void saveScore(Score score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/scores.txt", true))) {
            writer.write(score.getDate().toString() + "," + score.getPlayerName() + "," + score.getScore());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la puntuación: " + e.getMessage());
        }
    }
    public Object[] toObjectArray() {
        return new Object[]{date, playerName, score};
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int value) {
        score+= value;
    }
    public void updateScoreDisplay() {

        gameBoard.updateScoreLabel(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void run() {
        while (true) {
            Point head = gameBoard.getSnake().getBody().getFirst();
            if(head.equals(new Point(gameBoard.getFood().getX(), gameBoard.getFood().getY()))){
                System.out.println("comio");
                int valueFood = gameBoard.incrementScore();
                incrementScore(valueFood);
                updateScoreDisplay();
            }
        }
    }
}
