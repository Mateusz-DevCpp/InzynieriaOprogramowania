package io.main;

import io.dekorator.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Pizza pizza = new Pizza();
        
        Pizza pm = new PizzaMozzarella(pizza);
        Pizza pmik = new PizzaKurczak(pm);
        
        System.out.println(pm.toString() + " za " + pm.getPrice());
        System.out.println(pmik.toString() + " za " + pmik.getPrice());
        
        //----------------------------------------------------------------------
        
        Pizza pkmk = new PizzaKurczak(new PizzaMozzarella(new PizzaKurczak(new Pizza())));
        System.out.println(pkmk.toString() + " za " + pkmk.getPrice());
        
    }
}
