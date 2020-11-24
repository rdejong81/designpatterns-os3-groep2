package observer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Main {

    public static void main(String[] args) {

        JFrame main = new JFrame();

        Mouse mouse = new Mouse(main);
        mouse.addListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("X " + e.getX() + " - Y " + e.getY());
            }

        });

        Keyboard keyboard = new Keyboard(main);
        keyboard.addListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}



