package Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainWindow {

    private PointPublisher pointPublisher;
    private PointDrawerSubscriber pointDrawer;

    public MainWindow() {

        // Initialize components
        JFrame main = new JFrame("Sketch");
        main.setSize(640, 400);
        main.setVisible(true);

        this.pointPublisher = new PointPublisher();
        this.pointDrawer = new PointDrawerSubscriber();

        // Subscribe to publisher
        this.pointPublisher.subscribe(this.pointDrawer);

        // Add pane to window
        main.setContentPane(this.pointDrawer);

        // Add mouse listeners
        main.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                pointPublisher.setPoint(new Point(e.getX(), e.getY()));
            }
            // Not used
            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        main.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pointPublisher.setPoint(new Point(e.getX(), e.getY()));
            }
            // Not used
            public void mouseMoved(MouseEvent e) {}
        });
    }
}