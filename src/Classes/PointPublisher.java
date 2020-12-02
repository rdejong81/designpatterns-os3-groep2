package Classes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PointPublisher implements IObservable<Point>
{

    private final List<IObserver<Point>> subscribers = new ArrayList<>();
    private Point point;

    @Override
    public IDisposable subscribe(IObserver<Point> subscriber) {
        this.subscribers.add(subscriber);
        return () -> this.subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (IObserver<Point> subscriber : subscribers) {
            subscriber.update(this.point);
        }
    }

    public void setPoint(Point point) {
        this.point = point;
        this.notifySubscribers();
    }
}