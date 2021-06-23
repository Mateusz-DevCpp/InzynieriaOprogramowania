package io.model.baza_danych;

import io.model.system.Pracownik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanychPracownikow extends BazaDanych<Pracownik>
{
    public BazaDanychPracownikow()
    {
        super();
        
        connect(/* ... */);
    }
    
    /*public boolean register(Pracownik newObj) 
    {
        boolean added = false;
        try(Connection con = connect(2))
        {      
            int id = newObj.getId();
            String imie = newObj.getImie();
            String nazwisko = newObj.getNazwisko();
            String miasto = newObj.getAdres().getMiasto();
            String ulica = newObj.getAdres().getUlica();
            String mieszkanie = newObj.getAdres().getMieszkanie();
            String kod_pocztowy = newObj.getAdres().getKodPocztowy();
            String email_prywatny = newObj.getKontaktPrywatny().getEmail();
            String nr_telefonu_prywatny = newObj.getKontaktPrywatny().getNrTelefonu();
            String email_sluzbowy = newObj.getKontaktSluzbowy().getEmail();
            String nr_telefonu_sluzbowy = newObj.getKontaktSluzbowy().getNrTelefonu();
            int id_karty = newObj.getKarta();
            int id_stanowiska = newObj.getStanowisko().getId();
            String nazwa  = newObj.getStanowisko().getNazwa();
            float zarobki = newObj.getStanowisko().getZarobki();
                                      
            PreparedStatement ps1 = null;
            String sql1 =  null;
            PreparedStatement ps2 = null;
            String sql2 =  null;
                        
            PreparedStatement tmp_ps1 = null;
            String tmp_sql1 =  null;
            PreparedStatement tmp_ps2 = null;
            String tmp_sql2 =  null;
            
            tmp_sql1 = "SELECT count(*) FROM stanowisko WHERE id = ?";
            tmp_ps1 = con.prepareStatement(tmp_sql1);
            tmp_ps1.setInt(1, id_stanowiska);
            ResultSet ex1 = tmp_ps1.executeQuery();      
         
            if(ex1.next())
            {
                String tmp = ex1.getString(1);
                System.out.println(tmp);
                if (tmp.contentEquals("0"))
                {
                    sql1 = "INSERT INTO stanowisko(id, nazwa, zarobki) VALUES(?, ?, ?)";
                    ps1 = con.prepareStatement(sql1);
                    ps1.setInt(1, id_stanowiska);
                    ps1.setString(2, nazwa);
                    ps1.setFloat(3, zarobki);
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
            
            tmp_sql2 = "SELECT count(*) FROM pracownik WHERE id = ?";
            tmp_ps2 = con.prepareStatement(tmp_sql2);
            tmp_ps2.setInt(1, id);
            ResultSet ex2 = tmp_ps2.executeQuery();      
         
            if(ex2.next())
            {
                String tmp = ex2.getString(1);
                System.out.println(tmp);
                if (tmp.contentEquals("0"))
                {
                    sql2 = "INSERT INTO pracownik(id, id_karty, imie, nazwisko, miasto, ulica, mieszkanie, kod_pocztowy, email_prywatny, nr_telefonu_prywatny, email_sluzbowy, nr_telefonu_sluzbowy, id_stanowiska) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps2 = con.prepareStatement(sql2);
                    ps2.setInt(1, id);
                    ps2.setInt(2, id_karty);
                    ps2.setString(3, imie);
                    ps2.setString(4, nazwisko);
                    ps2.setString(5, miasto);
                    ps2.setString(6, ulica);
                    ps2.setString(7, mieszkanie);
                    ps2.setString(8, kod_pocztowy);
                    ps2.setString(9, email_prywatny);
                    ps2.setString(10, nr_telefonu_prywatny);
                    ps2.setString(11, email_sluzbowy);
                    ps2.setString(12, nr_telefonu_sluzbowy);
                    ps2.setInt(13, id_stanowiska);
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
        System.out.println(added);
        return added;
    }*/
}
