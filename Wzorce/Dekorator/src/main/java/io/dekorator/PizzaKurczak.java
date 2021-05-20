package io.dekorator;

public class PizzaKurczak extends Pizza
{
    private static float CENA_ZA_KURCZAKA = 7;
    Pizza pizza_bazowa;
    
    public PizzaKurczak(Pizza pizza)
    {
        pizza_bazowa = pizza;
    }
    
    @Override
    public float getPrice() 
    {
        return pizza_bazowa.getPrice() + CENA_ZA_KURCZAKA;
    }
    
    @Override
    public String toString() 
    {
        return pizza_bazowa.toString() + " z Kurczakiem,";
    }
}
