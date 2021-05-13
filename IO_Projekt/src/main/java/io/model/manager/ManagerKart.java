package io.model.manager;

import io.model.baza_danych.BazaDanychKart;
import io.model.repozytorium.RepozytoriumKart;
import io.model.system.Karta;
import java.util.ArrayList;

public class ManagerKart implements Manager<Karta>
{
    private RepozytoriumKart karty_ram;
    private BazaDanychKart karty_bd;
    
    @Override
    public boolean register(Karta newObj)
    {
        return true;
    }

    @Override
    public boolean unregister(Karta obj) 
    {
        return true;
    }

    @Override
    public Karta get(int id)
    {
        return new Karta(0);
    }

    @Override
    public int count()
    {
        return 0;
    }

    @Override
    public boolean update(Karta old_obj, Karta new_obj) 
    {
    
        return true;
    }

    @Override
    public boolean update(int obj_id, Karta new_obj) 
    {
    
        return true;
    }

    @Override
    public int find(Karta obj) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Karta> findAll(String id) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
