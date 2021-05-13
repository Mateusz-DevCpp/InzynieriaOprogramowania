package io.model.system;

import java.util.List;

public class Karta 
{
    private int id;
    private boolean przypisana;
    private List<Lokalizacja> historia_lokalizacji;
    private Uprawnienia posiadane_uprawiniena;

    public Karta(int id) 
    {
        this.id = id;
        /// wczytanie z bazy danych historii dla karty nr ...
    }
    
    /// static 
    static private int id_counter = 0;
    static public void init()
    {
        
    }
}
