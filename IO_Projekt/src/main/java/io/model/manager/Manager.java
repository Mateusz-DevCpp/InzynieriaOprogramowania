package io.model.manager;

interface Manager<T>
{
    public boolean register(T newObj);
    public boolean unregister(T obj);
    public T get(int id);
    public int count();
    public boolean update(int obj_id, T new_obj);
    public int getMaxID();
}
