package view;
import model.GameBoard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewSnake extends JPanel {
    private GameBoard gameBoard;
    private Image skinSnake;
    private Image appleFood;
    private Image grassBG;


    public ViewSnake(GameBoard gameBoard) {
        this.gameBoard = gameBoard;

        setPreferredSize(new Dimension(gameBoard.getWidth() * 20, gameBoard.getHeight() * 20));
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        try {
            BufferedImage skin = ImageIO.read(new File("assets/skin.jpeg"));
            BufferedImage apple = ImageIO.read(new File("assets/manzana.png"));
            BufferedImage grass = ImageIO.read(new File("assets/pasto.jpeg"));

            skinSnake = skin.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            appleFood = apple.getScaledInstance(40, 20, Image.SCALE_SMOOTH);
            grassBG = grass.getScaledInstance(grass.getWidth() ,grass.getHeight() , Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
        if (gameBoard.eat()) {
            repaint();
        }
        drawGame(g);
    }

    private void drawGame(Graphics g) {

        g.drawImage(grassBG,0,0,gameBoard.getWidth()*20, gameBoard.getHeight()*20,this);

        g.setColor(Color.GREEN);
        for (Point snakePart : gameBoard.getSnake().getBody()) {
            g.drawImage(skinSnake, snakePart.x * 20, snakePart.y * 20, 20, 20, this);
        }

        g.setColor(Color.WHITE);
        for (Point bodyPart : gameBoard.getSnake().getBody()) {
            int centerX = bodyPart.x * 20 ;
            int centerY = bodyPart.y * 20 ;
            g.fillOval(centerX - 2, centerY - 2, 4, 4);
        }
        g.drawImage(appleFood,gameBoard.getFood().getX()*20, gameBoard.getFood().getY()*20,20,20,this);

        g.setColor(Color.GRAY);
            g.fillRect(gameBoard.getBarrier().getX()*20 , gameBoard.getBarrier().getY()*20 , 20, 20);
    }
}

