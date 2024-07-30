package java0729;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class FlyingObstacle {
    private int x, y, width, height, speedX, speedY;
    private final int startY;

    public FlyingObstacle(int x, int y, int width, int height, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
        this.startY = y; // 장애물의 초기 y 좌표
    }

    public void move() {
        x -= speedX;
        y += speedY;
        
        // 장애물이 화면 밖으로 나가지 않도록 처리
        if (y < startY - 50 || y > startY + 50) {
            speedY = -speedY;
        }
    }

    public boolean isOffScreen() {
        return x + width < 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}