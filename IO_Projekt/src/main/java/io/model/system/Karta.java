package io.model.system;

import java.util.List;

public class Karta 
{
    private int id;
    private List<Lokalizacja> historia_lokalizacji;

    public Karta(int id) 
    {
        this.id = id;
        /// wczytanie z bazy danych historii dla karty nr ...
    }
    
    /// static 
    static private int id_counter = 0;
    static public void init()
    {
        // pobranie z bazy danych max id dla kart i przypisanie tej wartosci do id_counter;
    }
}
