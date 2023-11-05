package view.home;

import view.ButtonDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Home extends JPanel {
    private DeveloperInfo info;
    private StartGame startGame;
    private JButton viewScoreHistory;

    public Home(ActionListener listener) {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1000,1000));
        setBackground(Color.gray);
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridheight = 2;
        startGame = new StartGame(listener);
        add(startGame,constraints);
        constraints.gridy =1;
        constraints.gridx =1;
        constraints.gridheight = 1;
        info = new DeveloperInfo();
        add(info,constraints);
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        viewScoreHistory = new ButtonDefault("Historial de Puntajes");
        viewScoreHistory.setActionCommand("viewScores");
        viewScoreHistory.addActionListener(listener);
        add(viewScoreHistory,constraints);
    }
    public String getInputName() {
        return startGame.getInputName().getText();
    }
}
