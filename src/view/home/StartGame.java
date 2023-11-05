package view.home;

import view.ButtonDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartGame extends JPanel {
    private JLabel name;
    private JTextField inputName;
    private JLabel levelText;
    private JComboBox level;
    private JButton startGame;

    public StartGame(ActionListener listener) {
        setLayout(new GridBagLayout());
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        name = new JLabel("Ingrese su Nick");
        inputName = new JTextField(12);
        levelText = new JLabel("Seleccione el nivel: ");
        level = new JComboBox<>(new String[]{"1","2","3"});
        startGame = new ButtonDefault("Iniciar Juego");

        add(name,constraints);
        constraints.gridx = 1;
        add(inputName,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(levelText,constraints);
        constraints.gridx = 1;
        add(level,constraints);

        constraints.gridy = 2;
        constraints.gridwidth = 2;

        constraints.fill = GridBagConstraints.BOTH;
        startGame.setActionCommand("start");
        startGame.addActionListener(listener);
        add(startGame,constraints);

    }

    public JTextField getInputName() {
        return inputName;
    }

    public String getLevel() {
        return level.getSelectedItem().toString();
    }
}
