package model;

public class Score extends Thread {
        private int score;
        private Snake snake;

        public Score(Snake snake) {
            this.snake = snake;
            this.score = 0;
        }

        public int getScore() {
            return score;
        }

        public void incrementScore(int value) {
            score += value;
        }

        @Override
        public void run() {


        }
    }
