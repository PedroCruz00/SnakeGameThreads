package presenter;

import model.GameBoard;
import view.GameOver;
import view.MyFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private MyFrame myFrame;
    private GameBoard gameBoard;
    private Dimension dimension;

    public Presenter(){
        gameBoard = new GameBoard(20, 20,this);
        myFrame = new MyFrame(gameBoard,this);
        myFrame.addKeyListener(gameBoard.getMove());
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comand = e.getActionCommand();
        if (comand.equals("start")){
            if (gameBoard.getFirstTime() == true) {
                myFrame.startGame();
                gameBoard.startGame();
            }else{
                gameBoard.resetGame();
                myFrame.addKeyListener(gameBoard.getMove());
                myFrame.startGame();
            }
        }
        if (comand.equals("home")){
            myFrame.goHome();
        }
        if (comand.equals("viewScores")){
            myFrame.showHistoryScore(gameBoard.loadScores());
            myFrame.getHistoryScores().setData(gameBoard.loadScores());
            myFrame.getHistoryScores().repaint();
            myFrame.getHistoryScores().revalidate();
        }
    }
    public void gameOver(){
        myFrame.gameOver(this);
        try {
            gameBoard.stopGame();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {  try {
        javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception e) {
        e.printStackTrace();
    }
        new Presenter();
    }
}
