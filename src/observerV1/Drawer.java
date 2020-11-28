package observerV1;

import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    private Point point;

    /**
     * Actually draw oval on screen
     *
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        if (point != null) {
            g.setColor(Color.red);
            g.fillOval(point.x - 20, point.y - 40, 20, 20);
        }
    }

    /**
     * Start drawing
     *
     * @param point Point containing X and Y axes
     */
    public void draw(Point point) {
        this.point = point;
        repaint();
    }
}
