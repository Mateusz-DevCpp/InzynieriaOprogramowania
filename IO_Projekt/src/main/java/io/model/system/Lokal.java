package io.model.system;

import java.time.LocalTime;

public class Lokal 
{
    private String nazwa;
    private int posX, posY;
    private String wymagane_uprawnienia;

    public Lokal(String nazwa, int posX, int posY, String wymagane_uprawnienia_oznaczenia) 
    {
        this.nazwa = nazwa;
        this.posX = posX;
        this.posY = posY;
        this.wymagane_uprawnienia = wymagane_uprawnienia_oznaczenia;
    }
    
    public String toString()
    {
        String result;
        
        result = nazwa + "[" + wymagane_uprawnienia + "]";
        
        return result;
    }

    public String getNazwa() 
    {
        return nazwa;
    }

    public int getPosX() 
    {
        return posX;
    }

    public int getPosY() 
    {
        return posY;
    }

    public String getWymaganeUprawnienia() 
    {
        return wymagane_uprawnienia;
    }
    
    public boolean maDostep(Karta karta)
    {
        Uprawnienia uprawnienia = karta.getPosiadaneUprawiniena();
        
        LocalTime actualTime = LocalTime.now();
        
        if(uprawnienia.getGodzinaRozpoczecia().compareTo(actualTime) == -1 &&
            uprawnienia.getGodzinaZakonczenia().compareTo(actualTime) == 1)
        {
            return uprawnienia.getPoziomDostepu().contains(wymagane_uprawnienia);
        }
        else
        {
            return false;
        }
    }
}
