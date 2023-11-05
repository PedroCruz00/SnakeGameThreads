package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ButtonDefault extends JButton implements MouseListener {

    public ButtonDefault(String text) {
        super(text);
        this.setBounds(300, 250, 100, 30);

        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setBackground(new Color(25, 23, 23));
        this.setBorder(BorderFactory.createLineBorder(new Color(25, 23, 23),3));
    }
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public void setActionCommand(String actionCommand) {
        super.setActionCommand(actionCommand);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(new Color(241, 239, 239));
        this.setBorder(BorderFactory.createLineBorder(new Color(119, 118, 118),3));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(25, 23, 23));
        this.setBorder(BorderFactory.createLineBorder(new Color(25, 23, 23),3));

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(new Color(241, 239, 239));
        this.setBorder(BorderFactory.createLineBorder(new Color(119, 118, 118),3));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(25, 23, 23));

    }

}
