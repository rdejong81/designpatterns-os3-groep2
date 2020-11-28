package panels;

import Project_TCP_Connection.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CirclePanel extends JPanel {

    private final List<Circle> circleList = new LinkedList<Circle>();

    public void addCircle(Circle circle){
        circleList.add(circle);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        for (Circle c: circleList
             ) {
            c.draw(g);
        }
    }
}
