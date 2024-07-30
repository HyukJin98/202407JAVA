package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class ShootingGameWithEnemies extends JPanel implements ActionListener {

    private Timer timer;
    private int playerX = 100, playerY = 400;
    private int bulletX = -10, bulletY = -10;
    private boolean shooting = false;

    private ArrayList<Rectangle> enemies = new ArrayList<>();
    private ArrayList<Rectangle> bossProjectiles = new ArrayList<>();
    private Rectangle boss;
    private Random rand = new Random();

    // 방향키 입력 처리 변수
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;

    // 게임 오버 상태
    private boolean gameOver = false;

    // 게임 클리어 상태
    private boolean gameCleared = false;

    // 보스 이동 관련 변수
    private int bossSpeed = 5;
    private int bossDirection = 1; // 1: 오른쪽, -1: 왼쪽
    private int bossHealth = 300; // 보스 체력

    // 보스 출현 관련 변수
    private boolean bossAppeared = false;
    private int bossAppearanceTime = 50000; // 5초 후 보스 출현 (밀리초)
    private long gameStartTime;

    public ShootingGameWithEnemies() {
        timer = new Timer(16, this); // 약 60 FPS
        timer.start();
        gameStartTime = System.currentTimeMillis(); // 게임 시작 시간 기록
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver || gameCleared) return; // 게임 오버 또는 클리어 상태에서는 입력 처리하지 않음

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftPressed = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = true;
                        break;
                    case KeyEvent.VK_UP:
                        upPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        if (!shooting) {
                            shooting = true;
                            bulletX = playerX + 20;
                            bulletY = playerY;
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;
                }
            }
        });

        // 적 생성
        for (int i = 0; i < 5; i++) {
            enemies.add(new Rectangle(rand.nextInt(750), rand.nextInt(300), 50, 50));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", getWidth() / 2 - 150, getHeight() / 2);
            return;
        }

        if (gameCleared) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("You Win!", getWidth() / 2 - 100, getHeight() / 2);
            return;
        }

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50); // 플레이어

        g.setColor(Color.RED);
        if (shooting) {
            g.fillRect(bulletX, bulletY, 10, 5); // 총알
        }

        g.setColor(Color.GREEN);
        for (Rectangle enemy : enemies) {
            g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height); // 적
        }

        if (bossAppeared) {
            g.setColor(Color.ORANGE);
            g.fillRect(boss.x, boss.y, boss.width, boss.height); // 보스

            // 보스 체력 바
            g.setColor(Color.BLACK);
            g.drawRect(boss.x, boss.y + boss.height + 10, boss.width, 10);
            g.setColor(Color.RED);
            g.fillRect(boss.x, boss.y + boss.height + 10, (int) (boss.width * ((double) bossHealth / 100)), 10);

            // 보스의 총알
            g.setColor(Color.YELLOW);
            for (Rectangle projectile : bossProjectiles) {
                g.fillRect(projectile.x, projectile.y, 10, 5); // 보스의 총알
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver || gameCleared) return; // 게임 오버 또는 클리어 상태에서는 업데이트하지 않음

        // 보스 출현 타이밍
        if (!bossAppeared && System.currentTimeMillis() - gameStartTime > bossAppearanceTime) {
            bossAppeared = true;
            boss = new Rectangle(300, 50, 100, 100); // 보스 생성
        }

        if (shooting) {
            bulletY -= 5; // 총알이 위로 이동
            if (bulletY < 0) {
                shooting = false; // 총알이 화면을 벗어나면 멈춤
            }

            // 총알과 적의 충돌 처리
            for (int i = 0; i < enemies.size(); i++) {
                Rectangle enemy = enemies.get(i);
                if (new Rectangle(bulletX, bulletY, 10, 5).intersects(enemy)) {
                    enemies.remove(i);
                    shooting = false;
                    break;
                }
            }

            // 총알과 보스의 충돌 처리
            if (bossAppeared && new Rectangle(bulletX, bulletY, 10, 5).intersects(boss)) {
                bossHealth -= 10; // 보스 체력 감소
                shooting = false;
                if (bossHealth <= 0) {
                    gameCleared = true; // 체력이 다 떨어지면 게임 클리어 상태로 전환
                }
            }
        }

        // 플레이어 이동
        int playerSpeed = 5; // 플레이어 이동 속도
        if (leftPressed && playerX > 0) {
            playerX -= playerSpeed;
        }
        if (rightPressed && playerX < getWidth() - 50) {
            playerX += playerSpeed;
        }
        if (upPressed && playerY > 0) {
            playerY -= playerSpeed;
        }
        if (downPressed && playerY < getHeight() - 50) {
            playerY += playerSpeed;
        }

        // 적 이동 (하강)
        for (Rectangle enemy : enemies) {
            enemy.y += 2;
            if (enemy.y > getHeight()) {
                enemy.y = -enemy.height;
                enemy.x = rand.nextInt(getWidth() - enemy.width);
            }

            // 적과 플레이어의 충돌 처리
            if (new Rectangle(playerX, playerY, 50, 50).intersects(enemy)) {
                gameOver = true;
            }
        }

        // 보스 이동
        if (bossAppeared) {
            boss.x += bossSpeed * bossDirection;
            if (boss.x < 0 || boss.x > getWidth() - boss.width) {
                bossDirection *= -1; // 방향 반전
            }

            // 보스의 총알 생성 및 이동
            if (rand.nextInt(100) < 2) { // 확률로 총알 생성
                bossProjectiles.add(new Rectangle(boss.x + boss.width / 2, boss.y + boss.height, 10, 5));
            }
            ArrayList<Rectangle> toRemove = new ArrayList<>();
            for (Rectangle projectile : bossProjectiles) {
                projectile.y += 3;
                if (projectile.y > getHeight()) {
                    toRemove.add(projectile);
                }

                // 보스 총알과 플레이어의 충돌 처리
                if (new Rectangle(playerX, playerY, 50, 50).intersects(projectile)) {
                    gameOver = true;
                }
            }
            bossProjectiles.removeAll(toRemove);
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game with Enemies");
        ShootingGameWithEnemies game = new ShootingGameWithEnemies();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
