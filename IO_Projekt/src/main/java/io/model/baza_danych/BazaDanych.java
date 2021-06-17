package io.model.baza_danych;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanych<T>
{
    public BazaDanych()
    {
        
    }
    
    public static void connect()
    {
        /*String jdbcURL = "jdbc:postgresql://localhost:5432/SYS_ZARZ_PRAC";
        String username = "postgres";
        String password = "IO2021#";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");
            
            connection.close();
            
        } catch (SQLException ex) {
            System.out.println("Error  in connection to PostgreSQL server");
            ex.printStackTrace();
        }*/
        
        String url = "jdbc:postgresql://localhost:5432/SYS_ZARZ_PRAC";
        String user = "postgres";
        String password = "IO2021#";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            DatabaseMetaData dbm = con.getMetaData();
            // check if "Karta" table is there
            ResultSet tables = dbm.getTables(null, null, "Karta", null);
            if (tables.next()) {
                System.out.println("Data Base exists");
            }
            else {
                
                try (Statement st = con.createStatement()) {

                con.setAutoCommit(false);
                
                st.addBatch("CREATE TABLE Historia_lokalizacji(id_karty integer NOT NULL, id_lokalizacji integer NOT NULL, data date NOT NULL)");
                st.addBatch("CREATE TABLE Karta(id integer NOT NULL, przypisana boolean NOT NULL, posiadane_uprawnienia text NOT NULL)");
                st.addBatch("ALTER TABLE Karta ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME Karta_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE MAXVALUE 100000 CACHE 1)");
                st.addBatch("CREATE TABLE Lokal(id integer NOT NULL, nazwa text NOT NULL, posX integer NOT NULL, posY integer NOT NULL, id_uprawnienia text NOT NULL)");
                st.addBatch("ALTER TABLE Lokal ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME Lokal_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE MAXVALUE 10000 CACHE 1)");
                st.addBatch("CREATE TABLE Lokalizacja(id integer NOT NULL, id_lokalu integer NOT NULL)");
                st.addBatch("ALTER TABLE Lokalizacja ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME Lokalizacja_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE MAXVALUE 10000 CACHE 1)");
                st.addBatch("CREATE TABLE Pracownik(id integer NOT NULL, id_karty integer NOT NULL, imie text NOT NULL, nazwisko text NOT NULL, miasto text NOT NULL, ulica text,  mieszkanie text, kod_pocztowy text NOT NULL, email_prywatny text, nr_telefonu_prywatny integer, email_sluzbowy text, nr_telefonu_sluzbowy integer, id_stanowiska integer NOT NULL)");
                st.addBatch("ALTER TABLE Pracownik ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME Pracownik_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE MAXVALUE 1000000 CACHE 1)");
                st.addBatch("CREATE TABLE Stanowisko(id integer NOT NULL, nazwa text NOT NULL)");
                st.addBatch("ALTER TABLE Stanowisko ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME Stanowisko_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE MAXVALUE 10000 CACHE 1)");
                st.addBatch("CREATE TABLE Uprawnienia(id text NOT NULL, godzina_rozpoczenia time with time zone NOT NULL, godzina_zakonczenia time with time zone NOT NULL)");
                st.addBatch("CREATE TABLE Wynagrodzenie(id_pracownika integer NOT NULL, stawka_za_nadgodziny integer, data_otrzymania date NOT NULL, ilosc_nadgodzin integer)");
                st.addBatch("ALTER TABLE ONLY Karta ADD CONSTRAINT Karta_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Lokal ADD CONSTRAINT Lokal_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Lokalizacja ADD CONSTRAINT Lokalizacja_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Pracownik ADD CONSTRAINT Pracownik_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Stanowisko ADD CONSTRAINT Stanowisko_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Uprawnienia ADD CONSTRAINT Uprawnienia_pkey PRIMARY KEY (id)");
                st.addBatch("ALTER TABLE ONLY Pracownik ADD CONSTRAINT FK_id_karty FOREIGN KEY (id_karty) REFERENCES Karta(id) NOT VALID");
                st.addBatch("ALTER TABLE ONLY Historia_lokalizacji ADD CONSTRAINT FK_id_karty FOREIGN KEY (id_karty) REFERENCES Karta(id)");
                st.addBatch("ALTER TABLE ONLY Historia_lokalizacji ADD CONSTRAINT FK_id_lokalizacji FOREIGN KEY (id_lokalizacji) REFERENCES Lokalizacja(id)");
                st.addBatch("ALTER TABLE ONLY Lokalizacja ADD CONSTRAINT FK_id_lokalu FOREIGN KEY (id_lokalu) REFERENCES Lokal(id)");
                st.addBatch("ALTER TABLE ONLY Pracownik ADD CONSTRAINT FK_id_stanowiska FOREIGN KEY (id_stanowiska) REFERENCES Stanowisko(id) NOT VALID");
                st.addBatch("ALTER TABLE ONLY Lokal ADD CONSTRAINT FK_id_uprawnienia FOREIGN KEY (id_uprawnienia) REFERENCES Uprawnienia(id) NOT VALID");
                
                int counts[] = st.executeBatch();

                con.commit();

                System.out.println("Committed " + counts.length + " updates");
                
            } catch (SQLException ex) {

                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException ex1) {
                        Logger lgr = Logger.getLogger(
                                BazaDanych.class.getName());
                        lgr.log(Level.WARNING, ex1.getMessage(), ex1);
                    }
                }

                Logger lgr = Logger.getLogger(
                        BazaDanych.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
                
                System.out.println("Created Data Base");
            }
            
            

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(
                    BazaDanych.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
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
