package io.model.manager;

import io.model.baza_danych.BazaDanychKart;
import io.model.repozytorium.RepozytoriumKart;
import io.model.system.Karta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerKart implements Manager<Karta>
{
    private RepozytoriumKart repo_ram = null;
    private BazaDanychKart repo_baz = null;
    
    public ManagerKart()
    {
        repo_ram = new RepozytoriumKart();
        repo_baz = new BazaDanychKart();
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
            Logger.getLogger(ManagerKart.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return con;    
    }
    
    @Override
    public void rozlacz(Connection con)
    {     
        try {  
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerKart.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    @Override
    public boolean register(Karta newObj) 
    {
        boolean register_status = false;
        
        //if(repo_baz.register(newObj))
        //{
            register_status = repo_ram.add(newObj);
        //}
        
        return register_status;
    }

    @Override
    public boolean unregister(Karta obj) 
    {
        boolean unregister_status = false;
        
        //if(repo_baz.unregister(obj))
        //{
            unregister_status = repo_ram.remove(obj);
        //}
        
        return unregister_status;
    }

    @Override
    public Karta get(int id) 
    {
        return repo_ram.get(id);
    }
    
    public Karta getByCardID(int id)
    {
        for(int i=0; i<repo_ram.size(); i++)
        {
            if(repo_ram.get(i).getId() == id)
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
    public boolean update(int obj_id, Karta new_obj) 
    {
        return repo_baz.update(obj_id, new_obj);
    }

    @Override
    public int getMaxID() 
    {
        return 0;
    }
}
