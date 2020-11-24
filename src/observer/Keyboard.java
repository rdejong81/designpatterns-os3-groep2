package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public class Keyboard {

    private final Set<KeyListener> keyListeners;

    private final Component component;

    /**
     * Start timer to check if a action was performec
     *
     * @param component frame
     */
    public Keyboard(Component component) {
        this.component = component;

        // Check on a timer if a new event was triggered
        Timer timer = new Timer(50, new ActionListener() {
            private String lastPoint;

            @Override
            public synchronized void actionPerformed(ActionEvent e) {
                // Get current mouse location
                String key = KeyEvent.getKeyCode();

                // Check if current position is not the same as previous
                if (!key.equals(lastPoint)) {
                    fireListener(key);
                }
                lastPoint = key;
            }
        });
        this.keyListeners = new HashSet<>();
        timer.start();
    }

    /**
     * Add and start event listener
     *
     * @param listener the event listener to be started
     */
    public void addListener(KeyListener listener) {
        synchronized (this.keyListeners) {
            this.keyListeners.add(listener);
        }
    }

    /**
     * When listener is fired add information to object
     *
     * @param $key
     */
    public void fireListener(String $key) {
        synchronized (this.keyListeners) {
            for (final KeyListener listener : this.keyListeners) {
                final KeyEvent event =
                        new KeyEvent(this.component, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                                0, listener.hashCode());

                SwingUtilities.invokeLater(() -> listener.keyPressed(event));
            }
        }
    }

}
