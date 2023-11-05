package view;

import model.GameBoard;
import view.home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyFrame  extends JFrame {

    private ViewSnake gameView;
    private GameBoard gameBoard;
   private Home home;
   private ScoreView scoreView;
    private GameOver gameOverPanel;
    private HistoryScores historyScores;
    public MyFrame(GameBoard gameBoard,ActionListener listener) throws HeadlessException {
        super("Snake Game");
        this.gameBoard = gameBoard;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000,800));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        pack();
        initPanel(listener);
        setVisible(true);
    }

    private void initPanel(ActionListener listener){
        home = new Home(listener);
        gameOverPanel = new GameOver(gameBoard,listener);
        scoreView = new ScoreView();
        add(home);
    }
    public void startGame(){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        gameView = new ViewSnake(gameBoard);
        scoreView.setSize(gameBoard.getWidth(),gameBoard.getHeight()/8);
        gameView.setSize(gameBoard.getWidth(),gameBoard.getHeight());
        gameView.revalidate();
        gameView.repaint();

        add(scoreView);

        scoreView.setVisible(true);
        constraints.gridy = 1 ;
        constraints.gridheight = 10 ;

        add(gameView);
        home.setVisible(false);
        gameView.setVisible(true);
    }
    public void goHome(){
        home.setVisible(true);
        home.repaint();
        home.revalidate();
        gameView.setVisible(false);
        gameOverPanel.setVisible(false);
        scoreView.setVisible(false);
    }
    public void gameOver(ActionListener listener){
        gameOverPanel.setVisible(true);
        if (gameBoard.getMove().isGameOver()) {
            gameView.setVisible(false);
            gameOverPanel.setPreferredSize(new Dimension(gameBoard.getWidth() * 20, gameBoard.getHeight() * 20));
            this.add(gameOverPanel);
            this.revalidate();
            this.repaint();
        }
    }

    public void showHistoryScore(Object[][] data){
        historyScores = new HistoryScores(this,true,data);
        historyScores.setData(data);
        historyScores.repaint();
        historyScores.revalidate();
        historyScores.setVisible(true);
    }

    public HistoryScores getHistoryScores() {
        return historyScores;
    }

    public String gentNamePlayer() {
        return home.getInputName();
    }
    public void repaintViewSnake(){
        gameView = new ViewSnake(gameBoard);
    }

    public ScoreView getScoreView() {
        return scoreView;
    }
    public String getLevel(){
        return home.getLevel();
    }
}
