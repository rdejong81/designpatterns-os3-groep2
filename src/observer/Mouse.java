package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public class Mouse {
    private final Set<MouseMotionListener> mouseMotionListeners;

    private final Component component;

    private Point lastPoint;
    private boolean isDrawing = false;

    /**
     * Start timer to check if a action was performec
     *
     * @param component frame
     */
    public Mouse(Component component) {
        this.component = component;

        // Mouse motion listener
        component.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Get current mouse location
                Point point = new Point(e.getX(), e.getY());

                // Check if current position is not the same as previous
                if (!point.equals(lastPoint) && isDrawing) {
                    fireListener(point);
                }
                lastPoint = point;
            }
        });

        // Mouse listener
        component.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                isDrawing = !isDrawing;
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
        });

        this.mouseMotionListeners = new HashSet<>();

    }

    /**
     * Add and start event listener
     *
     * @param listener the event listener to be started
     */
    public void addListener(MouseMotionListener listener) {
        synchronized (this.mouseMotionListeners) {
            this.mouseMotionListeners.add(listener);
        }
    }

    /**
     * When listener is fired add information to object
     *
     * @param point mouse location details
     */
    public void fireListener(Point point) {
        synchronized (this.mouseMotionListeners) {
            for (final MouseMotionListener listener : this.mouseMotionListeners) {
                final MouseEvent event =
                        new MouseEvent(this.component, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                                0, point.x, point.y, 0, false);

                SwingUtilities.invokeLater(() -> listener.mouseMoved(event));
            }
        }
    }

}
