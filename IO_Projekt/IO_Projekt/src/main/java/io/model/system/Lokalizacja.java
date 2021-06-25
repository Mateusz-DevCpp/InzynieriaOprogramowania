package io.model.system;

import java.util.Date;

public class Lokalizacja 
{
    private Date data;
    private Lokal lokal;
    private boolean dostep_przyznany;

    public Lokalizacja(Lokal lokal, boolean dostep_przyznany) 
    {
        this.lokal = lokal;
        this.dostep_przyznany = dostep_przyznany;
        
        data = new Date();
    }

    public Date getData() 
    {
        return data;
    }

    public Lokal getLokal() 
    {
        return lokal;
    }

    public boolean isDostepPrzyznany() 
    {
        return dostep_przyznany;
    }

    public String toString()
    {
        String result;
        
        result = "Dostep ";
        if(dostep_przyznany) result += " PRZYZNANY";
        else result += " NIEPRZYZNANY";
        result += "\n";
        result += data.toString();
        result += "\n";
        result += lokal.toString();
        
        return result;
    }
}
