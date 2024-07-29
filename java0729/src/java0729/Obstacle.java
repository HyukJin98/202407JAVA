package java0729;

import java.awt.*;

public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;

    public Obstacle(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void move() {
        x -= speed;
    }

    public boolean isOffScreen() {
        return x + width < 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    // Getters for x and y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}