package io.model.manager;

import java.sql.Connection;

interface Manager<T>
{
    public Connection polacz();
    public void rozlacz(Connection connection);
    public boolean register(T newObj);
    public boolean unregister(T obj);
    public T get(int id);
    public int count();
    public boolean update(int obj_id, T new_obj);
    public int getMaxID();
}
