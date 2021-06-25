package io.model.system;

import io.gui.Main;
import java.util.ArrayList;

public class Karta 
{
    private int id;
    private boolean przypisana;
    private Uprawnienia posiadane_uprawiniena;
    private ArrayList<Lokalizacja> historia_lokalizacji;

    public Karta(int id, Uprawnienia posiadane_uprawiniena, boolean przypisana) 
    {
        this.id = id;
        this.posiadane_uprawiniena = posiadane_uprawiniena;
        this.przypisana = przypisana;
        
        historia_lokalizacji = new ArrayList<Lokalizacja>();
    }

    public String toString()
    {
        String res = "Karta o id [";
        
        res += Integer.toString(id);
        res += "] ";
        if(przypisana) res += "- [PRZYPISANA]";
        else res += "- [WOLNA]";
        
        
        return res;
    }
    
    public void wyczyscHistorie()
    {
        historia_lokalizacji.clear();
    }

    public ArrayList<Lokalizacja> getHistoria() 
    {
        return historia_lokalizacji;
    }
    
    public void dodajLokalizacje(Lokalizacja lokalizacja)
    {
        historia_lokalizacji.add(lokalizacja);
    }
    
    public int getId() 
    {
        return id;
    }

    public boolean isPrzypisana() 
    {
        return przypisana;
    }

    public void setPrzypisana(boolean przypisana) 
    {
        this.przypisana = przypisana;
    }

    public Uprawnienia getPosiadaneUprawiniena() 
    {
        return posiadane_uprawiniena;
    }
    
    public void setPosiadaneUprawiniena(Uprawnienia posiadane_uprawiniena) 
    {
        this.posiadane_uprawiniena = posiadane_uprawiniena;
    }
    
    /// static 
    static private int id_counter = 0;
    static public void init()
    {
        id_counter = Main.manager_kart.getMaxID() + 1;
    }
}
