package view;

import javax.swing.*;

public class ScoreView extends JPanel {
    private JLabel scoreLable;

    public ScoreView() {
        scoreLable = new JLabel("Score: " + "0" );
        this.add(scoreLable);
    }

    public void updateScoreLabel(int score) {
        scoreLable.setText("Score: " + score);

    }
}
