package interfaces;

public interface IObservable<Type>
{
    IDisposable subscribe(IObserver<Type> observer);
}
