package Project_TCP_Connection;

import panels.CirclePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CircleClickListener implements MouseListener {

    private final short subtract = 12;

    private final CirclePanel panel;


    public CircleClickListener(CirclePanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getX());
        panel.addCircle(new Circle(e.getX() - subtract, e.getY() - subtract, 24,Color.BLUE));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
