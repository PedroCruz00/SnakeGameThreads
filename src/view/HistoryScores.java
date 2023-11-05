package view;

import javax.swing.*;
import java.awt.*;

public class HistoryScores extends JDialog {
        private JTable table;
        private Object[][]data;
        private String[]column;

        public HistoryScores(MyFrame parent,boolean modal,Object[][]data) {
            super(parent,modal);
            setSize(new Dimension(400,400));
            setLayout(new GridLayout());
            setBackground(new Color(241, 239, 239));
            this.column = new  String[]{ "Fehcha-Hora","Nombre","Puntaje"};
            this.data = data;
            initComponents();
        }

        public void setData(Object[][] data) {
            this.data = data;
        }

        public void initComponents(){
            table = new JTable(data, column);
            table.setBackground(new Color(25, 23, 23));
            table.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
            table.setForeground(Color.WHITE);
            JScrollPane scrollPane = new JScrollPane(table);
            this.add(scrollPane);
        }
}
