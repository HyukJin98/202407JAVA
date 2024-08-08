package java0729;

import javax.swing.*;

public class GameMain {
    public static void main(String[] args) {
        System.out.println("혁진이 바보 ");
    	JFrame frame = new JFrame("Dino Jump Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}