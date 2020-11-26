package observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

        this.component.addKeyListener(new KeyListener() {
            private char lastPoint;

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                // Check if current key is not the same as previous
                if (key != lastPoint) {
                    fireListener(key, e.getKeyCode());
                }
                lastPoint = key;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.keyListeners = new HashSet<>();

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
     * @param key pressed key
     */
    public void fireListener(char key, int keyCode) {
        synchronized (this.keyListeners) {
            for (final KeyListener listener : this.keyListeners) {
                final KeyEvent event =
                        new KeyEvent(this.component, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                                0, keyCode, key);

                SwingUtilities.invokeLater(() -> listener.keyPressed(event));
            }
        }
    }

}
