package Program;

import interfaces.IDisposable;
import Classes.PointDrawerSubscriber;
import Classes.PointPublisher;
import Classes.PointWriterSubscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.event.InputEvent.*;

public class MainWindow
{

    private final PointPublisher pointPublisher;
    private final PointDrawerSubscriber pointDrawer;
    private PointWriterSubscriber pointWriterSubscriber;
    private IDisposable subscriptionDrawer;
    private IDisposable subscriptionWriter;
    private JFrame main;

    public MainWindow(PointPublisher pointPublisher,WindowListener windowListener) {

        // Initialize components
        main = new JFrame("MainWindow");
        main.setSize(640, 400);

        this.pointPublisher = pointPublisher;
        this.pointDrawer = new PointDrawerSubscriber();
        this.pointWriterSubscriber = new PointWriterSubscriber(pointDrawer);

        main.addWindowListener(windowListener);

        // Add pane to window
        main.setContentPane(this.pointDrawer);
        main.setVisible(true);

        // Add subscription button
        Button button = new Button("Toggle subscribe/unsubscribe");
        main.add(button);
        button.addActionListener((e)->{
            if(subscriptionDrawer == null)
            {
                // Subscribe to publisher
                subscriptionDrawer = this.pointPublisher.subscribe(this.pointDrawer);
                subscriptionWriter = this.pointPublisher.subscribe(this.pointWriterSubscriber);
            }
            else
            {
                subscriptionDrawer.dispose();
                subscriptionDrawer = null;
                subscriptionWriter.dispose();
                subscriptionWriter = null;
            }
            main.setTitle(subscriptionDrawer == null ? "MainWindow" : "MainWindow (Subscribed)" );
        });

        // Add mouse listeners
        main.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                // left mouse button
                if((e.getModifiersEx() & BUTTON1_DOWN_MASK) == BUTTON1_DOWN_MASK && subscriptionDrawer != null)
                    pointPublisher.setPoint(new Point(e.getX(), e.getY()));
                // right mouse button
                if((e.getModifiersEx() & BUTTON3_DOWN_MASK) == BUTTON3_DOWN_MASK)
                {
                    MainWindow newWindow = new MainWindow(pointPublisher,windowListener);
                    newWindow.setPosition(main);
                }
            }
            // Not used
            public void mouseClicked(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        main.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                // left mouse button
                if((e.getModifiersEx() & BUTTON1_DOWN_MASK) == BUTTON1_DOWN_MASK && subscriptionDrawer != null)
                    pointPublisher.setPoint(new Point(e.getX(), e.getY()));
            }
            // Not used
            public void mouseMoved(MouseEvent e) {}
        });
    }

    void setPosition(Component component)
    {
        this.main.setLocationRelativeTo(component);
        this.main.setLocation(component.getLocation().x+50,component.getLocation().y+50);
    }
}