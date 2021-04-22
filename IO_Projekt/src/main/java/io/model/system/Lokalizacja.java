package io.model.system;

import java.util.Date;

public class Lokalizacja 
{
    private Date data;
    private String pozycja;

    public Lokalizacja(String pozycja) 
    {
        this.pozycja = pozycja;
    }

    public Date getData() 
    {
        return data;
    }

    public String getPozycja() 
    {
        return pozycja;
    }
}
