package view;

import model.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    private GameOver gameOver;
    private MyFrame myFrame;
    private JLabel score;
    public GameOver(GameBoard gameBoard,ActionListener listener) {
        setLayout(new GridBagLayout());
        gameOver = this;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        JLabel gameOverLabel = new JLabel("Game Over");
        JButton home = new ButtonDefault("volver al inicio");
        home.setActionCommand("home");
        home.addActionListener(listener);
        gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 24));

        constraints.gridwidth = 2;
        add(gameOverLabel, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 1;
        score = new JLabel("Su puntaje fue: " + gameBoard.getScore().getScore());
        add(score,constraints);
        constraints.gridy = 2;
        this.add(home,constraints);
    }
}
