package io.model.manager;

import io.model.baza_danych.BazaDanychWynagrodzen;
import io.model.repozytorium.RepozytoriumWynagrodzen;
import io.model.system.Pracownik;
import io.model.system.Wynagrodzenie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerWynagrodzen implements Manager<Wynagrodzenie>
{
    private RepozytoriumWynagrodzen repo_ram = null;
    private BazaDanychWynagrodzen repo_baz = null;
    
    public ManagerWynagrodzen()
    {
        repo_ram = new RepozytoriumWynagrodzen();
        repo_baz = new BazaDanychWynagrodzen();
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
            Logger.getLogger(ManagerWynagrodzen.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return con;    
    }
    
    @Override
    public void rozlacz(Connection con)
    {     
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerWynagrodzen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean register(Wynagrodzenie newObj) 
    {
        boolean register_status = false;
        
        //if(repo_baz.register(newObj))
        //{
            register_status = repo_ram.add(newObj);
        //}
        
        return register_status;
    }

    @Override
    public boolean unregister(Wynagrodzenie obj) 
    {        
        boolean unregister_status = false;
        
        //if(repo_baz.unregister(obj))
        //{
            unregister_status = repo_ram.remove(obj);
        //}
        
        return unregister_status;
    }

    @Override
    public Wynagrodzenie get(int id) 
    {
        return repo_ram.get(id);
    }
  
    @Override
    public int count() 
    {
        return repo_ram.size();
    }

    @Override
    public boolean update(int obj_id, Wynagrodzenie new_obj) 
    {
        return repo_baz.update(obj_id, new_obj);
    }

    @Override
    public int getMaxID() 
    {
        return 0;
    }
}