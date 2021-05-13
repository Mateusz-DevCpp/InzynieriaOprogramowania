package io.model.system;

import java.time.LocalTime;

class Uprawnienia
{
    private int poziom_dostepu;
    LocalTime godzina_rozpoczecia = null;
    LocalTime godzina_zakonczenia = null;

    public Uprawnienia(int poziom_dostepu) 
    {
        this.poziom_dostepu = poziom_dostepu;
        godzina_rozpoczecia = LocalTime.parse("08:30");
        godzina_zakonczenia = LocalTime.parse("20:30");
    }
    
    
}
