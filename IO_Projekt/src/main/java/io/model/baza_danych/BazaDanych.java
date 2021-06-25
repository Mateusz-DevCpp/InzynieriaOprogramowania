package io.model.baza_danych;

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
    
    public static void createDataBase() 
    {
	try(Connection con = connect(1)) {
            
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT count(*) FROM pg_catalog.pg_database WHERE datname = 'sys_zarz_prac_test';");
          
          while (rs.next())
          {
              String tmp = rs.getString(1);
              if (tmp.contentEquals("0"))
              {
                  //System.out.println("No existing Data Base");
                  
                  Statement st2 = con.createStatement();
                  st2.executeUpdate("CREATE DATABASE sys_zarz_prac_test;");
                  
                  //System.out.println("Created Data Base");
              }
              else
              {
                  //System.out.println("Data Base exists");
              }    
          }    
          disconnect(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }				
    }			
    
    public static void createTables()
    {   
        try(Connection con = connect(2)) {
            
            DatabaseMetaData databaseMetaData = con.getMetaData();  
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});

            if (resultSet.next()) {
                //System.out.println("Tables already exist");
            }
            else 
            {
                //System.out.println("No tables, proceed to create tables...");         
                Statement st = con.createStatement();

                    st.executeUpdate("CREATE TABLE Historia_lokalizacji(id_karty integer NOT NULL, id_lokalizacji integer NOT NULL, data date NOT NULL)");
                    st.executeUpdate("CREATE TABLE Karta(id integer NOT NULL, przypisana boolean NOT NULL, posiadane_uprawnienia text NOT NULL)");               
                    st.executeUpdate("CREATE TABLE Lokal(id SERIAL NOT NULL, nazwa text NOT NULL, opis text NOT NULL, posX integer NOT NULL, posY integer NOT NULL, id_uprawnienia text NOT NULL)");
                    st.executeUpdate("CREATE TABLE Lokalizacja(id SERIAL NOT NULL, id_lokalu integer NOT NULL)");
                    st.executeUpdate("CREATE TABLE Pracownik(id integer NOT NULL, id_karty integer NOT NULL, imie text NOT NULL, nazwisko text NOT NULL, miasto text NOT NULL, ulica text,  mieszkanie text, kod_pocztowy text NOT NULL, email_prywatny text, nr_telefonu_prywatny text, email_sluzbowy text, nr_telefonu_sluzbowy text, id_stanowiska integer NOT NULL)");
                    st.executeUpdate("CREATE TABLE Stanowisko(id integer NOT NULL, nazwa text NOT NULL, zarobki double precision)");
                    st.executeUpdate("CREATE TABLE Uprawnienia(id text NOT NULL, godzina_rozpoczenia time without time zone NOT NULL, godzina_zakonczenia time without time zone NOT NULL)");
                    st.executeUpdate("CREATE TABLE Wynagrodzenie(id_pracownika integer NOT NULL, stawka_za_nadgodziny integer, data_otrzymania date NOT NULL, ilosc_nadgodzin integer)");
                    st.executeUpdate("ALTER TABLE ONLY Karta ADD CONSTRAINT Karta_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Lokal ADD CONSTRAINT Lokal_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Lokalizacja ADD CONSTRAINT Lokalizacja_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Pracownik ADD CONSTRAINT Pracownik_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Stanowisko ADD CONSTRAINT Stanowisko_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Uprawnienia ADD CONSTRAINT Uprawnienia_pkey PRIMARY KEY (id)");
                    st.executeUpdate("ALTER TABLE ONLY Pracownik ADD CONSTRAINT FK_id_karty FOREIGN KEY (id_karty) REFERENCES Karta(id) NOT VALID");
                    st.executeUpdate("ALTER TABLE ONLY Historia_lokalizacji ADD CONSTRAINT FK_id_karty FOREIGN KEY (id_karty) REFERENCES Karta(id)");
                    st.executeUpdate("ALTER TABLE ONLY Historia_lokalizacji ADD CONSTRAINT FK_id_lokalizacji FOREIGN KEY (id_lokalizacji) REFERENCES Lokalizacja(id)");
                    st.executeUpdate("ALTER TABLE ONLY Lokalizacja ADD CONSTRAINT FK_id_lokalu FOREIGN KEY (id_lokalu) REFERENCES Lokal(id)");
                    st.executeUpdate("ALTER TABLE ONLY Pracownik ADD CONSTRAINT FK_id_stanowiska FOREIGN KEY (id_stanowiska) REFERENCES Stanowisko(id) NOT VALID");
                    st.executeUpdate("ALTER TABLE ONLY Lokal ADD CONSTRAINT FK_id_uprawnienia FOREIGN KEY (id_uprawnienia) REFERENCES Uprawnienia(id) NOT VALID");
                    st.executeUpdate("ALTER TABLE ONLY Karta ADD CONSTRAINT FK_posiadane_uprawnieia FOREIGN KEY (posiadane_uprawnienia) REFERENCES Uprawnienia(id) NOT VALID");
                    
                    st.executeUpdate("CREATE TABLE Loginfo(username text NOT NULL, password text NOT NULL, id integer NOT NULL)");
                    st.executeUpdate("ALTER TABLE ONLY Loginfo ADD CONSTRAINT Loginfo_pkey PRIMARY KEY (id)");
                    //System.out.println("Created tables");
                    //st.executeUpdate("CREATE TABLE Loginfo(username character varying(10)[] NOT NULL, password character varying(10)[])");
                    //st.executeUpdate("ALTER TABLE ONLY Loginfo ADD CONSTRAINT Loginfo_pkey PRIMARY KEY (username)");
            }           
            disconnect(con);
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Connection connect(int dataBase)
    {       
        String url1 = "jdbc:postgresql://localhost:5432/";
        String url2 = "jdbc:postgresql://localhost:5432/sys_zarz_prac_test";
        String user = "postgres";
        String password = "Akacja";
        
        try {
            Connection con = null;
            switch (dataBase) 
            {
                case 1: 
                    con = DriverManager.getConnection(url1, user, password);
                    //System.out.println("Opened connection with PostgreSQL");
                    break;
                case 2:
                    con = DriverManager.getConnection(url2, user, password);
                    //System.out.println("Opened connection with Data Base");
                    break;
                default:
                    break;
            }
            return con;
            
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    public static void disconnect(Connection con) {
        try {
            con.close();
            //System.out.println("Closed connection");
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
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
