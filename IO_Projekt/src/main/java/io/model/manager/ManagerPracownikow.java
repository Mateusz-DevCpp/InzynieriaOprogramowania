package io.model.manager;

import io.model.baza_danych.BazaDanychPracownikow;
import io.model.repozytorium.RepozytoriumPracownikow;
import io.model.system.Pracownik;

public class ManagerPracownikow implements Manager<Pracownik>
{
    private RepozytoriumPracownikow repo_ram = null;
    private BazaDanychPracownikow repo_baz = null;
    
    public ManagerPracownikow()
    {
        repo_ram = new RepozytoriumPracownikow();
        repo_baz = new BazaDanychPracownikow();
    }
    
    @Override
    public boolean register(Pracownik newObj) 
    {
        boolean register_status = false;
        
        //if(repo_baz.register(newObj))
        //{
            register_status = repo_ram.add(newObj);
        //}
        
        return register_status;
    }

    @Override
    public boolean unregister(Pracownik obj) 
    {
        boolean unregister_status = false;
        
        //if(repo_baz.unregister(obj))
        //{
            unregister_status = repo_ram.remove(obj);
        //}
        
        return unregister_status;
    }

    @Override
    public Pracownik get(int id) 
    {
        return repo_ram.get(id);
    }

    public Pracownik getByPracownikID(int id)
    {
        for(int i=0; i<repo_ram.size(); i++)
        {
            if(repo_ram.get(i).getId()== id)
            {
                return repo_ram.get(i);
            }
        }
        return null;
    }
    
    @Override
    public int count() 
    {
        return repo_ram.size();
    }

    @Override
    public boolean update(int obj_id, Pracownik new_obj) 
    {
        return repo_baz.update(obj_id, new_obj);
    }

    @Override
    public int getMaxID() 
    {
        return 0;
    }

}
