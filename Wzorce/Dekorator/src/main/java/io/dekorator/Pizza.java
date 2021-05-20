package io.dekorator;

import java.util.ArrayList;

public class Pizza 
{
    private static float CENA_ZA_BAZE = 20;
    
    private float cena = CENA_ZA_BAZE;

    public Pizza() 
    {
        
    }
    
    public float getPrice() 
    {
        return cena;
    }
    
    @Override
    public String toString() 
    {
        return "Pizza";
    }
}
    
