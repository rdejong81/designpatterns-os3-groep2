package Project_TCP_Connection;

import panels.CirclePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circles");

        CirclePanel panel = new CirclePanel();
        frame.setContentPane(panel);

        panel.addMouseListener(new CircleClickListener(panel));

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
