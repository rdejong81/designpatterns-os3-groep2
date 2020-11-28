package Classes;

import Classes.IObserver;

import javax.swing.*;
import java.awt.*;

public class PointDrawerSubscriber extends JPanel implements IObserver<Point>
{

    private Point point;

    public void paintComponent(Graphics g) {

        if (point != null)
        {
            g.setColor(Color.red);
            g.fillOval(point.x - 20, point.y - 40, 20, 20);
        }
    }

    @Override
    public void update(Point point) {
        this.point = point;

        this.paintComponent(this.getGraphics());

    }
}