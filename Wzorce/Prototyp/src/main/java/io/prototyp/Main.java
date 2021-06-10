package io.prototyp;

public class Main 
{
    public static void main(String[] args) 
    {
        Kolo k = new Kolo();
        k.x = 10;
        k.y = 10;
        k.promien = 30;
        k.kolor = "Zielony";

        Prostokat p = new Prostokat();
        p.x = 0;
        p.y = 0;
        p.wysokosc = 10;
        p.szerokosc = 20;
        p.kolor = "Rozowy";
        
        Ksztalt k_cpy = null;
        
        k_cpy = (Kolo) k;
        if(k == k_cpy)
            System.out.println("to jest ten sam obiekt");
        else if(k.equals(k_cpy))
            System.out.println("to nie jest ten sam obiekt, to jest kopia");
        else
            System.out.println("to sa rozne obiekty");
        
        k_cpy = (Kolo) k.clone();
        if(k == k_cpy)
            System.out.println("to jest ten sam obiekt");
        else if(k.equals(k_cpy))
            System.out.println("to nie jest ten sam obiekt, to jest kopia");
        else
            System.out.println("to sa rozne obiekty");
        
        k_cpy = (Prostokat) p.clone();
        if(k == k_cpy)
            System.out.println("to jest ten sam obiekt");
        else if(k.equals(k_cpy))
            System.out.println("to nie jest ten sam obiekt, to jest kopia");
        else
            System.out.println("to sa rozne obiekty");
            
    }
}
