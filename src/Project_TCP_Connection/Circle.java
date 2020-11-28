package Project_TCP_Connection;

import java.awt.*;

public class Circle {

    private final float x;
    private final float y;
    private final float diameter;
    private final Color color;

    public Circle(float x, float y, float diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,(int)diameter, (int)diameter);
    }
}
