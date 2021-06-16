package io.model.baza_danych;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BazaDanych<T>
{
    public BazaDanych()
    {
        
    }
    
    public static void connect()
    {
        String jdbcURL = "jdbc:postgresql://localhost:5432/SYS_ZARZ_PRAC";
        String username = "postgres";
        String password = "IO2021#";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");
            
            connection.close();
            
        } catch (SQLException ex) {
            System.out.println("Error  in connection to PostgreSQL server");
            ex.printStackTrace();
        }
    }
    
    public int getMaxID()
    {
        // pobiera max id z bazy danych zwiekasz o 1 i zwraca
        return 1;
    }
    
    public T get(int id)
    {
        return null;
    }
    
    public boolean register(T newObj) 
    {
        return false;
    }

    public boolean unregister(T obj) 
    {
        return false;
    }

    public boolean update(T old_obj, T new_obj) 
    {
        return false;
    }

    public boolean update(int obj_id, T new_obj) 
    {
        return false;
    }
    
    public int find(String id)
    {
        return 0;
    }

    public int count() 
    {
        return 0;
    }
}
