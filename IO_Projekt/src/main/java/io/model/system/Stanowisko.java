package io.model.system;

public class Stanowisko
{
    private int id;
    private String nazwa;
    private float zarobki;

    public Stanowisko( int id, String nazwa, float zarobki) 
    {
        this.id = id;
        this.nazwa = nazwa;
        this.zarobki = zarobki;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
