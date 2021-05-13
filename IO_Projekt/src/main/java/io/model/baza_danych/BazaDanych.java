package io.model.baza_danych;

public abstract class BazaDanych<T>
{
    public BazaDanych()
    {
        
    }
    
    public static void connect()
    {
        
    }
    
    public int getNextID()
    {
        // pobiera max id z bazy danych zwiekasz o 1 i zwraca
        return 1;
    }
    
    public boolean register(T newObj) 
    {
        return false;
    }

    public boolean unregister(T obj) 
    {
        return false;
    }

    public boolean update(T old_obj, T new_obj) 
    {
        return false;
    }

    public boolean update(int obj_id, T new_obj) 
    {
        return false;
    }

    public int find(String id) 
    {
        return 0;
    }

    public T get(int id) 
    {
        return null;
    }

    public int count() 
    {
        return 0;
    }
}
