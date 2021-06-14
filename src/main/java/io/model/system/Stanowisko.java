package io.model.system;

public class Stanowisko
{
    private String nazwa;
    private float zarobki;

    public Stanowisko(String nazwa, float zarobki) 
    {
        this.nazwa = nazwa;
        this.zarobki = zarobki;
    }
    
    public String getNazwa() 
    {
        return nazwa;
    }

    public void setNazwa(String nazwa) 
    {
        this.nazwa = nazwa;
    }

    public float getZarobki() 
    {
        return zarobki;
    }

    public void setZarobki(float zarobki) 
    {
        this.zarobki = zarobki;
    }
}
