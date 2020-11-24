package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public class Mouse {
    private final Set<MouseMotionListener> mouseMotionListeners;

    private final Component component;

    /**
     * Start timer to check if a action was performec
     *
     * @param component frame
     */
    public Mouse(Component component) {
        this.component = component;

        // Check on a timer if a new event was triggered
        Timer timer = new Timer(50, new ActionListener() {
            private Point lastPoint = MouseInfo.getPointerInfo().getLocation();

            @Override
            public synchronized void actionPerformed(ActionEvent e) {
                // Get current mouse location
                Point point = MouseInfo.getPointerInfo().getLocation();

                // Check if current position is not the same as previous
                if (!point.equals(lastPoint)) {
                    fireListener(point);
                }
                lastPoint = point;
            }
        });
        this.mouseMotionListeners = new HashSet<>();
        timer.start();
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
