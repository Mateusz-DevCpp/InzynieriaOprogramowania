package io.model.manager;

import io.model.baza_danych.BazaDanychLokali;
import io.model.repozytorium.RepozytoriumLokali;
import io.model.system.Lokal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerLokali implements Manager<Lokal>
{
    private RepozytoriumLokali repo_ram = null;
    private BazaDanychLokali repo_baz = null;
    
    public ManagerLokali()
    {
        repo_ram = new RepozytoriumLokali();
        repo_baz = new BazaDanychLokali();
    }

    @Override
    public Connection polacz()
    {     
        String url = "jdbc:postgresql://localhost:5432/sys_zarz_prac_test";
        String user = "postgres";
        String password = "IO2021#";
        
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerLokali.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;    
    }
    
    @Override
    public void rozlacz(Connection con)
    {      
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerLokali.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public boolean register(Lokal newObj) 
    {
        boolean register_status = false;
        
        //if(repo_baz.register(newObj))
        //{
            register_status = repo_ram.add(newObj);
        //}
        
        return register_status;

    }

    @Override
    public boolean unregister(Lokal obj) 
    {
        boolean unregister_status = false;
        
        //if(repo_baz.unregister(obj))
        //{
            unregister_status = repo_ram.remove(obj);
        //}
        
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
    
    public boolean update(Lokal old_obj, Lokal new_obj) 
    {
        old_obj.setNazwa( new_obj.getNazwa() );
        old_obj.setWymaganeUprawnienia(new_obj.getWymaganeUprawnienia() );
        old_obj.setOpis( new_obj.getOpis());
        old_obj.setPosX( new_obj.getPosX());
        old_obj.setPosY( new_obj.getPosY());
        return true;
    }

    @Override
    public int getMaxID() 
    {
        return 0;
    }
}