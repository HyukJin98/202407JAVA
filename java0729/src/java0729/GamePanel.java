package java0729;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private int dinoY = 250;
    private int dinoVelY = 0;
    private boolean isJumping = false;
    private boolean isFallingFaster = false;
    private final int GROUND = 250;
    private final int DINO_WIDTH = 30;
    private final int DINO_HEIGHT = 30;
    private final int OBSTACLE_WIDTH = 20;
    private final int OBSTACLE_HEIGHT = 50;
    private int score = 0;
    private int time = 0;
    private int obstacleSpeed = 10;
    private int obstacleInterval = 2000;
    private final int SPEED_INCREMENT_INTERVAL = 10000;
    private final int SPEED_INCREMENT_AMOUNT = 2;
    private final int INTERVAL_DECREMENT_AMOUNT = 100;
    private boolean isGameOver = false;
    private int highScore = 0;
    private JButton restartButton;
    private List<Obstacle> obstacles;
    private Timer obstacleSpawnTimer;
    private Timer difficultyIncreaseTimer;

    private static final String HIGH_SCORE_FILE = "highscore.dat"; // 최고 기록 파일 이름

    public GamePanel() {
        setPreferredSize(new Dimension(800, 300));
        setBackground(Color.WHITE);

        timer = new Timer(20, this);
        timer.start();

        obstacleSpawnTimer = new Timer(obstacleInterval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnObstacle();
            }
        });
        obstacleSpawnTimer.start();

        difficultyIncreaseTimer = new Timer(SPEED_INCREMENT_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseDifficulty();
            }
        });
        difficultyIncreaseTimer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumping && !isGameOver) {
                    isJumping = true;
                    dinoVelY = -15;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && isJumping && !isGameOver) {
                    isFallingFaster = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    isFallingFaster = false;
                }
            }
        });
        setFocusable(true);

        restartButton = new JButton("다시 시작");
        restartButton.setBounds(350, 140, 100, 30);
        restartButton.setVisible(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        setLayout(null);
        add(restartButton);

        obstacles = new ArrayList<>();
        loadHighScore(); // 게임 시작 시 최고 기록을 불러옴
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            if (isJumping) {
                dinoY += dinoVelY;
                dinoVelY += 1;
                if (dinoY >= GROUND) {
                    dinoY = GROUND;
                    dinoVelY = 0;
                    isJumping = false;
                }
            }

            if (isFallingFaster) {
                dinoVelY += 2;
            }

            for (Obstacle obstacle : obstacles) {
                obstacle.move();
            }

            if (!obstacles.isEmpty() && obstacles.get(0).isOffScreen()) {
                obstacles.remove(0);
                score += 10;
            }

            time += 1;

            checkCollision();
            repaint();
        }
    }

    private void checkCollision() {
        Rectangle dinoRect = new Rectangle(50, dinoY, DINO_WIDTH, DINO_HEIGHT);

        for (Obstacle obstacle : obstacles) {
            if (dinoRect.intersects(obstacle.getBounds())) {
                isGameOver = true;
                timer.stop();
                obstacleSpawnTimer.stop();
                difficultyIncreaseTimer.stop();
                if (score > highScore) {
                    highScore = score;
                    saveHighScore(); // 최고 기록을 파일에 저장
                }
                restartButton.setVisible(true);
                repaint();
            }
        }
    }

    private void spawnObstacle() {
        if (!isGameOver) {
            int x = 800;
            int y = GROUND;
            obstacles.add(new Obstacle(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT, obstacleSpeed));
        }
    }

    private void increaseDifficulty() {
        if (!isGameOver) {
            obstacleSpeed += SPEED_INCREMENT_AMOUNT;
            if (obstacleInterval > 500) {
                obstacleInterval -= INTERVAL_DECREMENT_AMOUNT;
                obstacleSpawnTimer.setDelay(obstacleInterval);
            }
        }
    }

    private void restartGame() {
        isGameOver = false;
        dinoY = GROUND;
        dinoVelY = 0;
        isJumping = false;
        isFallingFaster = false;
        obstacles.clear();
        score = 0;
        time = 0;
        obstacleSpeed = 10;
        obstacleInterval = 2000;
        restartButton.setVisible(false);
        timer.start();
        obstacleSpawnTimer.setDelay(obstacleInterval);
        obstacleSpawnTimer.start();
        difficultyIncreaseTimer.start();
    }

    private void loadHighScore() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HIGH_SCORE_FILE))) {
            highScore = ois.readInt();
        } catch (IOException e) {
            highScore = 0; // 파일이 없거나 읽기 오류가 발생한 경우 기본값 설정
        }
    }

    private void saveHighScore() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HIGH_SCORE_FILE))) {
            oos.writeInt(highScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(50, dinoY, DINO_WIDTH, DINO_HEIGHT);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }

        // 점수와 시간 표시
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Time: " + (time / 50) + "s", 10, 40);
        g.drawString("High Score: " + highScore, 10, 60);

        // 게임 오버 시 최고 기록과 다시 시작 버튼 표시
        if (isGameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.RED);
            g.drawString("Game Over", 300, 100);
            g.setColor(Color.BLACK);
        }
    }
}