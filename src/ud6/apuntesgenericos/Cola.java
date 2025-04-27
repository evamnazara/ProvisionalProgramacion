package apuntesgenericos;

public interface Cola<T> {
    public void encolar(T e);

    public T desencolar();
}