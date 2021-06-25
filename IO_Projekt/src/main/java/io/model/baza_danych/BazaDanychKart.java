package io.model.baza_danych;

import io.model.system.Karta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanychKart extends BazaDanych<Karta>
{
    public BazaDanychKart()
    {
        super();
        
        createDataBase();
        createTables();
        
        //connect(/* ... */);
    }
    
    public boolean register(Karta newObj) 
    {
        boolean added = false;
        try(Connection con = connect(2))
        {      
            int id = newObj.getId();
            boolean przypisana = newObj.isPrzypisana();
            String uprawnienia = newObj.getPosiadaneUprawiniena().getPoziomDostepu();
            LocalTime godzina_rozpoczecia = newObj.getPosiadaneUprawiniena().getGodzinaRozpoczecia();
            Time time_rozp = Time.valueOf(godzina_rozpoczecia);
            LocalTime godzina_zakonczenia = newObj.getPosiadaneUprawiniena().getGodzinaZakonczenia();
            Time time_zak = Time.valueOf(godzina_zakonczenia);
            //ArrayList<Lokalizacja> historia_lokalizacji = newObj.getHistoria();
                                      
            PreparedStatement ps1 = null;
            String sql1 =  null;
            PreparedStatement ps2 = null;
            String sql2 =  null;
                        
            PreparedStatement tmp_ps1 = null;
            String tmp_sql1 =  null;
            PreparedStatement tmp_ps2 = null;
            String tmp_sql2 =  null;
            
            tmp_sql1 = "SELECT count(*) FROM uprawnienia WHERE id = ?";
            tmp_ps1 = con.prepareStatement(tmp_sql1);
            tmp_ps1.setString(1, uprawnienia);
            ResultSet ex1 = tmp_ps1.executeQuery();      
         
            if(ex1.next())
            {
                String tmp = ex1.getString(1);
                //System.out.println(tmp);
                if (tmp.contentEquals("0"))
                {
                    sql1 = "INSERT INTO uprawnienia(id, godzina_rozpoczenia, godzina_zakonczenia) VALUES(?, ?, ?)";
                    ps1 = con.prepareStatement(sql1);
                    ps1.setString(1, uprawnienia);
                    ps1.setTime(2, time_rozp);
                    ps1.setTime(3, time_zak);
                    ps1.executeUpdate();
                    ps1.close();

                    added = true;
                }
                else
                {
                    added = false;
                } 
            }              
            tmp_ps1.close();
            
            tmp_sql2 = "SELECT count(*) FROM karta WHERE id = ?";
            tmp_ps2 = con.prepareStatement(tmp_sql2);
            tmp_ps2.setInt(1, id);
            ResultSet ex2 = tmp_ps2.executeQuery();      
         
            if(ex2.next())
            {
                String tmp = ex2.getString(1);
                //System.out.println(tmp);
                if (tmp.contentEquals("0"))
                {
                    sql2 = "INSERT INTO karta(id, przypisana, posiadane_uprawnienia) VALUES(?, ?, ?)";
                    ps2 = con.prepareStatement(sql2);
                    ps2.setInt(1, id);
                    ps2.setBoolean(2, przypisana);
                    ps2.setString(3, uprawnienia);
                    ps2.executeUpdate();
                    ps2.close();

                    added = true;
                }
                else
                {
                    added = false;
                } 
            }              
            tmp_ps2.close();                    
    
            disconnect(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanychKart.class.getName()).log(Level.SEVERE, null, ex);
            
            added = false;
        }
        //System.out.println(added);
        return added;
    }
    
  /*  public Karta get(int id) 
    {
        BazaDanychKart repo_baza = null;
        
        try(Connection con = connect(2))
        {   
            int id_karty = id;
            int id_karta_tmp;
            boolean przypisana;
            String przypisane_uprawnienia;     
            
            PreparedStatement ps1 = null;
            String sql1 =  null;
                        
            PreparedStatement tmp_ps1 = null;
            String tmp_sql1 =  null;
    
            tmp_sql1 = "SELECT count(*) FROM karta WHERE id = ?";
            tmp_ps1 = con.prepareStatement(tmp_sql1);
            tmp_ps1.setInt(1, id_karty);
            ResultSet ex1 = tmp_ps1.executeQuery();      
         
            if(ex1.next())
            {
                String tmp = ex1.getString(1);
                //System.out.println("pierwszy if " + tmp);
                if (tmp.contentEquals("0"))
                {   
                    System.out.println("Brak kart o id" + tmp);
                }
                else
                {
                    sql1 = "SELECT * FROM karta WHERE id = ?";
                    ps1 = con.prepareStatement(sql1);
                    ps1.setInt(1, id_karty);
                    ResultSet ex2  = ps1.executeQuery();
                    
                    while (ex2.next()) 
                    {
                        id_karta_tmp = ex2.getInt(1);
                        przypisana = ex2.getBoolean(2);
                        przypisane_uprawnienia = ex2.getString(3);                     
                    }           
                    ps1.close();
                } 
            }              
            tmp_ps1.close();                
    
            disconnect(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanychKart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return repo_baza.get(id);
    }
    */
}
