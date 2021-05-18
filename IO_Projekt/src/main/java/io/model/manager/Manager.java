package io.model.manager;

import io.model.baza_danych.BazaDanych;
import io.model.repozytorium.Repozytorium;

public class Manager<T>
{
    private Repozytorium<T> repo_ram;
    private BazaDanych<T> repo_baz;

    public Manager() 
    {
        repo_ram = new Repozytorium<T>();
        repo_baz = new BazaDanych<T>();
    }
    
    public boolean register(T newObj) 
    {
        boolean register_status = false;
        
        if(repo_baz.register(newObj))
        {
            register_status = repo_ram.add(newObj);
        }
        
        return register_status;
    }

    public boolean unregister(T obj) 
    {
        boolean unregister_status = false;
        
        if(repo_baz.unregister(obj))
        {
            unregister_status = repo_ram.remove(obj);
        }
        
        return unregister_status;
    }

    public T get(int id)
    {
        return repo_ram.get(id);
    }

    public int count()
    {
        return repo_ram.size();
    }

    public boolean update(T old_obj, T new_obj) 
    {
        boolean update_status = false;
        
        if(repo_baz.update(old_obj, new_obj))
        {
            update_status = repo_ram.update(old_obj, new_obj);
        }
        
        return update_status;
    }

    public boolean update(int obj_id, T new_obj) 
    {
        boolean update_status = false;
        
        if(repo_baz.update(obj_id, new_obj))
        {
            update_status = repo_ram.update(obj_id, new_obj);
        }
        
        return update_status;
    }
    
    public int getMaxID() 
    {
        return repo_baz.getMaxID();
    }
}
