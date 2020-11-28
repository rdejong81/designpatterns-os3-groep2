package Listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main implements WindowListener
{
    private int openWindows=0;
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(new PointPublisher(),new Main());
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        openWindows++;
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        if(openWindows>0) openWindows--;
        if(openWindows==0) System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e)
    {

    }

    @Override
    public void windowIconified(WindowEvent e)
    {

    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {

    }

    @Override
    public void windowActivated(WindowEvent e)
    {

    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {

    }
}
