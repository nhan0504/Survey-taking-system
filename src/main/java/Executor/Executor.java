package Executor;

public interface Executor<T> {
    public void execute(int option);
    public T getCurrentObject();
}
