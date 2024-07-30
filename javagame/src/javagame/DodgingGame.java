package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DodgingGame extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 50;
    private static final int DUNG_SIZE = 30;
    private static final int DUNG_COUNT =20;
    private static final String RECORD_FILE = "highscore.txt";

    private Timer timer;
    private int playerX = WIDTH / 2 - PLAYER_SIZE / 2;
    private int playerY = HEIGHT - PLAYER_SIZE - 10;
    private ArrayList<Rectangle> dungs = new ArrayList<>();
    private Random random = new Random();
    private int dungSpeed = 5;
    private int gameTime = 0;
    private int highScore = 0;
    private boolean gameOver = false;

    private boolean moveLeft = false;
    private boolean moveRight = false;

    public DodgingGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) return;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        moveLeft = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (gameOver) return;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        moveLeft = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight = false;
                        break;
                }
            }
        });

        for (int i = 0; i < DUNG_COUNT; i++) {
            dungs.add(new Rectangle(random.nextInt(WIDTH - DUNG_SIZE), -DUNG_SIZE, DUNG_SIZE, DUNG_SIZE));
        }

        loadHighScore();

        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);

        g.setColor(Color.RED);
        for (Rectangle dung : dungs) {
            g.fillRect(dung.x, dung.y, dung.width, dung.height);
        }

        if (gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over!", WIDTH / 2 - 100, HEIGHT / 2 - 30);
            g.drawString("Time Survived: " + gameTime / 1000 + " seconds", WIDTH / 2 - 200, HEIGHT / 2 + 10);
            g.drawString("High Score: " + highScore / 1000 + " seconds", WIDTH / 2 - 200, HEIGHT / 2 + 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        if (moveLeft) {
            playerX -= 10;
        }
        if (moveRight) {
            playerX += 10;
        }
        playerX = Math.max(0, Math.min(WIDTH - PLAYER_SIZE, playerX));

        ArrayList<Rectangle> newDungs = new ArrayList<>();
        for (Rectangle dung : dungs) {
            dung.y += dungSpeed;
            if (dung.y < HEIGHT) {
                newDungs.add(dung);
            }
        }
        dungs = newDungs;

        if (dungs.size() < DUNG_COUNT) {
            dungs.add(new Rectangle(random.nextInt(WIDTH - DUNG_SIZE), -DUNG_SIZE, DUNG_SIZE, DUNG_SIZE));
        }

        gameTime += timer.getDelay();

        if (gameTime % 10000 == 0) { // Increase speed every 10 seconds
            dungSpeed++;
        }

        for (Rectangle dung : dungs) {
            if (dung.intersects(new Rectangle(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE))) {
                gameOver = true;
                timer.stop();
                if (gameTime > highScore) {
                    highScore = gameTime;
                    saveHighScore();
                }
                repaint();
                return;
            }
        }

        repaint();
    }

    private void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RECORD_FILE))) {
            highScore = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            highScore = 0;
        }
    }

    private void saveHighScore() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECORD_FILE))) {
            writer.write(String.valueOf(highScore));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dodging Game");
        DodgingGame game = new DodgingGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
