package Listener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PointPublisher {

    private final List<IObserver> subscribers = new ArrayList<>();
    private Point point;

    public void subscribe(IObserver subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unSubscribe(IObserver subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (IObserver subscriber : subscribers) {
            subscriber.update(this.point);
        }
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        this.notifySubscribers();
    }
}