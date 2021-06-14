package io.model.manager;

import io.model.repozytorium.RepozytoriumLokali;
import io.model.system.Lokal;

public class ManagerLokali implements Manager<Lokal>
{
    private RepozytoriumLokali repo_ram = null;
    
    public ManagerLokali()
    {
        repo_ram = new RepozytoriumLokali();
    }

    @Override
    public boolean register(Lokal newObj) 
    {
        boolean register_status = false;
        
        register_status = repo_ram.add(newObj);
        
        return register_status;
    }

    @Override
    public boolean unregister(Lokal obj) 
    {
        boolean unregister_status = false;
        
        unregister_status = repo_ram.remove(obj);
        
        return unregister_status;
    }

    public Lokal getByLocalName(String nazwa)
    {
        for(int i=0; i<repo_ram.size(); i++)
        {
            if(repo_ram.get(i).getNazwa()== nazwa)
            {
                return repo_ram.get(i);
            }
        }
        return null;
    }
    
    @Override
    public Lokal get(int id) 
    {
        return repo_ram.get(id);
    }

    @Override
    public int count() 
    {
        return repo_ram.size();
    }

    @Override
    public boolean update(int obj_id, Lokal new_obj) 
    {
        return false;
    }

    @Override
    public int getMaxID() 
    {
        return 0;
    }
}