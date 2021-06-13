package io.model.repozytorium;

public interface Repozytorium<T>
{
    public T get(int id);
    public boolean add(T newObject);
    public boolean remove(T object);
    public String report();
    public int size();
};