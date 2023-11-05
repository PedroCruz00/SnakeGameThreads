package view.home;

import javax.swing.*;
import java.awt.*;

public class DeveloperInfo extends JPanel {
    private JLabel name;
    private JLabel code;
    private JLabel faculty;
    private JLabel school;
    private JLabel year;
    private JLabel logo;

    public DeveloperInfo() {
        setLayout(new GridBagLayout());
        initComponents();
    }
    public void initComponents(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        this.name = new JLabel("Desarrollador: Pedro Eduardo Cruz López");
        add(name,constraints);

        constraints.gridy = 1;
        this.code = new JLabel("Codigo: 202128778");
        add(code,constraints);

        constraints.gridy = 2;
        this.faculty = new JLabel("Facultad de Ingenieria");
        add(faculty,constraints);

        constraints.gridy = 3;
        this.school = new JLabel("Ingenieria de sistemas y computación");
        add(school,constraints);

        constraints.gridy = 4;
        this.year = new JLabel("2023");
        add(year,constraints);

        constraints.gridy = 5;
        this.logo = new JLabel("Logo");
        add(logo,constraints);

    }
}
