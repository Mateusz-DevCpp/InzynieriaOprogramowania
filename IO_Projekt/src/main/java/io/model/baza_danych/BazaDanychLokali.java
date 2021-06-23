package io.model.baza_danych;
        
import io.model.system.Lokal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanychLokali extends BazaDanych<Lokal>
{
    public BazaDanychLokali()
    {
        super();
        
        //connect(/* ... */);
    }
    
    public boolean register(Lokal newObj) 
    {
        boolean added = false;
        try(Connection con = connect(2))
        {                  
            String nazwa = newObj.getNazwa();
            String opis = newObj.getOpis();
            int posx = newObj.getPosX();
            int posy = newObj.getPosY();
            String wymagane_uprawnienia = newObj.getWymaganeUprawnienia();
            
            PreparedStatement ps1 = null;
            String sql1 =  null;
                        
            PreparedStatement tmp_ps1 = null;
            String tmp_sql1 =  null;
    
            tmp_sql1 = "SELECT count(*) FROM lokal WHERE nazwa = ?";
            tmp_ps1 = con.prepareStatement(tmp_sql1);
            tmp_ps1.setString(1, nazwa);
            ResultSet ex1 = tmp_ps1.executeQuery();      
         
            if(ex1.next())
            {
                String tmp = ex1.getString(1);
                //System.out.println("pierwszy if " + tmp);
                if (tmp.contentEquals("0"))
                {   
                    sql1 = "INSERT INTO lokal(nazwa, opis, posx, posy, id_uprawnienia) VALUES(?, ?, ?, ?, ?)";
                    ps1 = con.prepareStatement(sql1);
                    ps1.setString(1, nazwa);
                    ps1.setString(2, opis);
                    ps1.setInt(3, posx);
                    ps1.setInt(4, posy);
                    ps1.setString(5, wymagane_uprawnienia);
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
    
            disconnect(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanychKart.class.getName()).log(Level.SEVERE, null, ex);
            
            added = false;
        }
        //System.out.println(added);
        return added;
    }
}
