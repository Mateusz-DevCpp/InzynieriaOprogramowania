package io.model.manager;

import io.model.baza_danych.BazaDanychKont;
import io.model.logowanie.Konto;


public class ManagerKont implements Manager<Konto>
{
    BazaDanychKont bd_kotna;
    
    public ManagerKont()
    {
        bd_kotna = new BazaDanychKont();
    }
    
    @Override
    public boolean register(Konto newObj) 
    {
        return bd_kotna.register(newObj);
    }

    @Override
    public boolean unregister(Konto obj) 
    {
        return bd_kotna.unregister(obj);
    }

    @Override
    public Konto get(int id) 
    {
        return bd_kotna.get(id);
    }

    @Override
    public int count() 
    {
        return bd_kotna.count();
    }

    @Override
    public boolean update(int obj_id, Konto new_obj) 
    {
        return bd_kotna.update(obj_id, new_obj);
    }

    @Override
    public int getMaxID() 
    {
        return bd_kotna.getMaxID();
    }
    
    public int probaLogowania(Konto konto)
    {
        return bd_kotna.tryLogin(konto);
    }
}
