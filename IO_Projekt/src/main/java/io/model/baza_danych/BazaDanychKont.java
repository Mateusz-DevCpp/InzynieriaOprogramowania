package io.model.baza_danych;

import io.model.logowanie.Konto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanychKont extends BazaDanych<Konto>
{
    public BazaDanychKont()
    {
        super();
        
        //connect(/* ... */);
    }
    
    public int tryLogin(Konto konto)
    {
        int log = 1;
        try(Connection con = connect(2)){

            String tmp_sql1 = "SELECT count(*) FROM loginfo";
            PreparedStatement tmp_ps1 = con.prepareStatement(tmp_sql1);
            ResultSet ex1 = tmp_ps1.executeQuery();      
         
            if(ex1.next())
            {
                String tmp = ex1.getString(1);
                if (tmp.contentEquals("0"))
                {
                    String sql1 = "INSERT INTO loginfo(username, password, id) VALUES(?, ?, ?)";
                    try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
                        ps1.setString(1, "admin");
                        ps1.setString(2, "haslo");
                        ps1.setInt(3, 1);
                        ps1.executeUpdate();
                    }
                }
            }              
            tmp_ps1.close();

            String tmp_sql = "SELECT id, username FROM loginfo WHERE username = ? AND password = ?";
            PreparedStatement tmp_ps = con.prepareStatement(tmp_sql);
            tmp_ps.setString(1, konto.getLogin());
            tmp_ps.setString(2, konto.getHaslo());
            ResultSet ex = tmp_ps.executeQuery();
            
            if(ex.next()){
                log = 0;
            }
            tmp_ps.close();
            disconnect(con);
        } 
        catch (SQLException ex) {
            Logger.getLogger(BazaDanychKart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;// 0 - logowanie powiodlo sie
    }
}
