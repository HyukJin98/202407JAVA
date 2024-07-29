package java0729;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private int dinoY = 250;
    private int dinoVelY = 0;
    private boolean isJumping = false;
    private final int GROUND = 250;
    private final int DINO_WIDTH = 50;
    private final int DINO_HEIGHT = 50;
    private final int OBSTACLE_WIDTH = 20;
    private final int OBSTACLE_HEIGHT = 50;
    private int score = 0;
    private int time = 0;
    private final int OBSTACLE_SPEED = 10;
    private final int OBSTACLE_INTERVAL = 2000;  // 장애물 생성 간격 (단위: 밀리초)
    private boolean isGameOver = false;
    private int highScore = 0;
    private JButton restartButton;
    private List<Obstacle> obstacles;
    private Timer obstacleSpawnTimer;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 300));
        setBackground(Color.WHITE);

        timer = new Timer(20, this);
        timer.start();

        obstacleSpawnTimer = new Timer(OBSTACLE_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnObstacle();
            }
        });
        obstacleSpawnTimer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumping && !isGameOver) {
                    isJumping = true;
                    dinoVelY = -15;
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

            for (Obstacle obstacle : obstacles) {
                obstacle.move();
            }

            if (!obstacles.isEmpty() && obstacles.get(0).isOffScreen()) {
                obstacles.remove(0);
                score += 10;  // 장애물을 넘을 때마다 점수 추가
            }

            time += 1;  // 게임 시간 증가 (20ms 간격)

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
                if (score > highScore) {
                    highScore = score;
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
            obstacles.add(new Obstacle(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT, OBSTACLE_SPEED));
        }
    }

    private void restartGame() {
        isGameOver = false;
        dinoY = GROUND;
        dinoVelY = 0;
        isJumping = false;
        obstacles.clear();
        score = 0;
        time = 0;
        restartButton.setVisible(false);
        timer.start();
        obstacleSpawnTimer.start();
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
        g.drawString("Time: " + (time / 50) + "s", 10, 40);  // time을 초 단위로 변환
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