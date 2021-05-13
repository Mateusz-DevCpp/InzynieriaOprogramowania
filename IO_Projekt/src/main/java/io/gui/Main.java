package io.gui;

import io.model.manager.*;
import io.model.system.*;

public class Main 
{
    public static ManagerKont manager_kont;
    public static ManagerPracownikow manager_pracownikow;
    public static ManagerKart manager_kart;
    
    static public void main(String[] args)
    {
        manager_kont = new ManagerKont();
        
        // Okno logowania ...
        
        manager_kont = null;
        
        /// konfiguracja poczatkowa
        Pracownik.init();
        Karta.init();
        
        manager_pracownikow = new ManagerPracownikow();
        manager_kart = new ManagerKart();
        
        
        
        /// przejscie do programu glownego
        Window.main(args);
    }
}
