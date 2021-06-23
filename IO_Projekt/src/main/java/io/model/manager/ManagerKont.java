package io.model.manager;

import io.model.baza_danych.BazaDanychKont;
import io.model.logowanie.Konto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;


public class ManagerKont implements Manager<Konto>
{
    BazaDanychKont bd_kotna;
    
    public ManagerKont()
    {
        bd_kotna = new BazaDanychKont();
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
            java.util.logging.Logger.getLogger(ManagerKont.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return con;    
    }
    
    @Override
    public void rozlacz(Connection con)
    {          
        try {
            con.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ManagerKont.class.getName()).log(Level.SEVERE, null, ex);
        }
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
