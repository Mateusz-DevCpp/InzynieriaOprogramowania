package io.model.repozytorium;

import java.util.ArrayList;
import java.util.List;

public class Repozytorium<T>
{
    List<T> objects;

    public Repozytorium() 
    {
        objects = new ArrayList<T>();
    }
    
    public T get(int id)
    {
        if(id < 0 || id >= objects.size())
            return null;
        
        return objects.get(id);
    }
    
    public boolean add(T newObject)
    {
        if(newObject == null)
            return false;
        
        return objects.add(newObject);
    }
    
    public boolean remove(T object)
    {
        if(object == null)
            return false;
        
        return objects.remove(object);
    }
    
    public String report()
    {
        String result = "";
        for(int i=0; i<objects.size(); i++)
        {
            result += objects.get(i).toString() + "\n";
        }
        return result;
    }
    
    public int size()
    {
        return objects.size();
    }
    
    public boolean update(T obj_id, T new_obj)
    {
        return true;
    }
    
    public boolean update(int obj_id, T new_obj)
    {
        return true;
    }
};