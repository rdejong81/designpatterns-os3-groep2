package Classes;

import Classes.IObserver;

import javax.swing.*;
import java.awt.*;

public class PointWriterSubscriber implements IObserver<Point>
{
    private final JPanel panel;

    public PointWriterSubscriber(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void update(Point value)
    {
        Graphics graphics = panel.getGraphics();

        graphics.clearRect(1,1,120,12);
        graphics.setColor(Color.BLACK);
        graphics.setFont(Font.getFont(Font.SANS_SERIF));
        graphics.drawString("x="+value.x+" y="+value.y,12,12);
    }
}
