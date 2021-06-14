package io.gui;

import io.model.manager.*;
import io.model.system.*;
import java.io.IOException;

public class Main 
{
    public static ManagerKont manager_kont;
    public static ManagerPracownikow manager_pracownikow;
    public static ManagerKart manager_kart;
    public static ManagerLokali manager_lokali;
    
    static public void main(String[] args) throws IOException
    {
        manager_pracownikow = new ManagerPracownikow();
        manager_kart = new ManagerKart();
        manager_lokali = new ManagerLokali();
        manager_kont = new ManagerKont();
        
        
        /// konfiguracja poczatkowa
        Pracownik.init();
        Karta.init();
        dodajDaneTestowe();
        
        /// Okno programu;
        Window.main(args);
        
        
        /// zamykanie programu
        manager_pracownikow = null;
        manager_kart = null;
        manager_lokali = null;
        manager_kont = null;
    }
    
    static private void dodajDaneTestowe()
    {
        manager_pracownikow.register(
            new Pracownik(0, "Adam", "Malysz", 
            new Adres("Lodz", "Adamow", "12", "12-123"), 
            new Kontakt("emailAM@poczta.pl", "123321123"),
            new Kontakt("emailAMDwa@poczta.pl", "321123321"), 1)
        );
        
        manager_pracownikow.register(
            new Pracownik(1, "Jeszcze", "Ktos", 
            new Adres("Lodz", "Adamow", "12", "12-123"), 
            new Kontakt("emailAM@poczta.pl", "123321123"),
            new Kontakt("emailAMDwa@poczta.pl", "321123321"), -1)
        );        
        
        manager_pracownikow.register(
            new Pracownik(2, "Ostatni", "Testowy", 
            new Adres("Lodz", "Adamow", "12", "12-123"), 
            new Kontakt("emailAM@poczta.pl", "123321123"),
            new Kontakt("emailAMDwa@poczta.pl", "321123321"), -1)
        );
        
        manager_kart.register(
                new Karta(1, 
                new Uprawnienia("A1", "00:01", "23:59"),
                false)
        );
        
        manager_pracownikow.get(0).setKarta(1);
        
        manager_lokali.register(
                new Lokal("Budynek 01 Pomieszczenie A1",
                71, 
                17, 
                "A1")
        );
        
        manager_lokali.register(
                new Lokal("Budynek 01 Pomieszczenie A2",
                77, 
                11, 
                "A2")
        );
        
        manager_kart.get(0).dodajLokalizacje(
                new Lokalizacja(
                    manager_lokali.get(0),
                    manager_lokali.get(0).maDostep(manager_kart.get(0)))
        );        
        
        manager_kart.get(0).dodajLokalizacje(
                new Lokalizacja(
                    manager_lokali.get(1),
                    manager_lokali.get(1).maDostep(manager_kart.get(0)))
        );
    }
}
