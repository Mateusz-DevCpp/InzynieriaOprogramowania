package io.model.manager;

import java.util.ArrayList;

public interface Manager<T>
{
    public boolean register(T newObj);
    public boolean unregister(T obj);
    public boolean update(T old_obj, T new_obj);
    public boolean update(int obj_id, T new_obj);
    public ArrayList<T> findAll(String id);
    public int find(T obj);
    public T get(int id);
    public int count();
}
