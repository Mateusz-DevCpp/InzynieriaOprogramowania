package io.model.system;

import java.time.LocalTime;

public class Uprawnienia
{
    private String uprawnienia_oznaczenia;
    private LocalTime godzina_rozpoczecia = null;
    private LocalTime godzina_zakonczenia = null;

    public Uprawnienia(String uprawnienia_oznaczenia, String od_godziny, String do_godziny) 
    {
        this.uprawnienia_oznaczenia = uprawnienia_oznaczenia;
        this.godzina_rozpoczecia = LocalTime.parse(od_godziny);
        this.godzina_zakonczenia = LocalTime.parse(do_godziny);
    }

    public String toString()
    {
        String res = "";
        
        res += "Dostp w godzinach:\n";
        res += godzina_rozpoczecia.toString() + " - " + godzina_zakonczenia.toString() + "\n";
        res += "\nLista uprawnien:\n";
        res += uprawnienia_oznaczenia;
        
        return res;
    }
    
    public String getPoziomDostepu() 
    {
        return uprawnienia_oznaczenia;
    }

    public void setPoziomDostepu(String uprawnienia_oznaczenia) 
    {
        this.uprawnienia_oznaczenia = uprawnienia_oznaczenia;
    }
    
    public void addDostep(String uprawnienia_oznaczenia) 
    {
        if(this.uprawnienia_oznaczenia.length() == 0)
            this.uprawnienia_oznaczenia += uprawnienia_oznaczenia;
        else
            this.uprawnienia_oznaczenia += "\n" + uprawnienia_oznaczenia;
    }
    
    public void rmDostep(String uprawnienia_oznaczenia)
    {
        String tmp = this.uprawnienia_oznaczenia.replace(uprawnienia_oznaczenia + "\n", "");
        if(tmp != this.uprawnienia_oznaczenia)
            this.uprawnienia_oznaczenia = tmp;
        else
            this.uprawnienia_oznaczenia = this.uprawnienia_oznaczenia.replace(uprawnienia_oznaczenia, "");
        
        if(this.uprawnienia_oznaczenia.charAt(this.uprawnienia_oznaczenia.length()-1) == '\n')
        {
            this.uprawnienia_oznaczenia = this.uprawnienia_oznaczenia.substring(0, this.uprawnienia_oznaczenia.length()-1);
        }
    }

    public LocalTime getGodzinaRozpoczecia() 
    {
        return godzina_rozpoczecia;
    }

    public void setGodzinaRozpoczecia(String od_godziny) 
    {
        this.godzina_rozpoczecia = LocalTime.parse(od_godziny);
    }

    public LocalTime getGodzinaZakonczenia() 
    {
        return godzina_zakonczenia;
    }

    public void setGodzinaZakonczenia(String do_godziny) 
    {
        this.godzina_zakonczenia = LocalTime.parse(do_godziny);
    }
    
}
