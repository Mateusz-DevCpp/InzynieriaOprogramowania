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
        //godzina_rozpoczecia = LocalTime.parse("08:30:00");
        //godzina_zakonczenia = LocalTime.parse("20:30:00");
    }

    public String getPoziomDostepu() 
    {
        return uprawnienia_oznaczenia;
    }

    public void setPoziomDostepu(String uprawnienia_oznaczenia) 
    {
        this.uprawnienia_oznaczenia = uprawnienia_oznaczenia;
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
