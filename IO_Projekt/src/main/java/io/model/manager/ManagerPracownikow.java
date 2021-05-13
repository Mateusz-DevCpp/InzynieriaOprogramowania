package io.model.manager;

import io.model.baza_danych.BazaDanychPracownikow;
import io.model.repozytorium.RepozytoriumPracownikow;
import io.model.system.Pracownik;
import java.util.ArrayList;

public class ManagerPracownikow implements Manager<Pracownik>
{
    private RepozytoriumPracownikow pracownicy_ram;
    private BazaDanychPracownikow pracownicy_bd;
    
    @Override
    public boolean register(Pracownik newObj) 
    {
        return true;
    }

    @Override
    public boolean unregister(Pracownik obj) 
    {
        return true;
    }

    @Override
    public Pracownik get(int id)
    {
        return new Pracownik(null,null,null,null,null,0);
    }

    @Override
    public int count()
    {
        return 0;
    }

    @Override
    public boolean update(Pracownik old_obj, Pracownik new_obj) 
    {
    
        return true;
    }

    @Override
    public boolean update(int obj_id, Pracownik new_obj) 
    {
    
        return true;
    }

    @Override
    public ArrayList<Pracownik> findAll(String id) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int find(Pracownik obj) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
