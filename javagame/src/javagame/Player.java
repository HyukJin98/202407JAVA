package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player {
    private int x, y;
    private int yVelocity = 0;
    private boolean isJumping = false;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (isJumping) {
            yVelocity += 1;
            y += yVelocity;
            if (y >= 500) { // 바닥에 닿으면 점프 종료
                y = 500;
                isJumping = false;
                yVelocity = 0;
            }
        }
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            yVelocity = -15;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }
}

