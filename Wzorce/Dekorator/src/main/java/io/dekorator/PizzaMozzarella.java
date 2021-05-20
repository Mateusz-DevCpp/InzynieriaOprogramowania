package io.dekorator;

public class PizzaMozzarella extends Pizza
{
    private static float CENA_ZA_MOZZARELLE = 5;
    Pizza pizza_bazowa;
    
    public PizzaMozzarella(Pizza pizza)
    {
        pizza_bazowa = pizza;
    }
    
    @Override
    public float getPrice() 
    {
        return pizza_bazowa.getPrice() + CENA_ZA_MOZZARELLE;
    }
    
    @Override
    public String toString() 
    {
        return pizza_bazowa.toString() + " z Mozzarella,";
    }
}
