package observerV1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Main {

    public static void main(String[] args) {

        JFrame main = new JFrame("Sketch");
        main.setSize(640, 400);
        main.setVisible(true);

        // Add drawer panel
        Drawer drawer = new Drawer();
        main.setContentPane(drawer);

        // Add mouse listener
        Mouse mouse = new Mouse(main);
        mouse.addListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                drawer.draw(new Point(e.getX(), e.getY()));
            }
        });

        // Add keyboard listener
        Keyboard keyboard = new Keyboard(main);
        keyboard.addListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar() + " pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}



