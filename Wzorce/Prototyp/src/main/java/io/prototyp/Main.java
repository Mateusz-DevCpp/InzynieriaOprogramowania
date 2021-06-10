package io.prototyp;

import io.prototyp.Animals.*;
import io.prototyp.Ksztalty.*;

public class Main {

    public static void main(String[] args) 
    {
        AnimalMain();
        //KsztaltyMain();
    }
    
    private static void AnimalMain()
    {
        CloneFactory animalMaker = new CloneFactory();
        Sheep dolly = new Sheep("czarny", "Dolly");
        Sheep clonedSheep = (Sheep) animalMaker.getClone(dolly);
        if(dolly != clonedSheep){
            System.out.println("Owce są innymi obiektami");
            if (clonedSheep.equals(dolly)){
                System.out.println(" mają identyczne wartości ");
            }
            else{
                System.out.println(" NIE mają identycznych wartości ");
            }
        }
        else{
            System.out.println("Owce są TYMI SAMYMI obiektami ");
        }
        System.out.println("Tutaj oryginalna owca: ");
        System.out.println(dolly);
        System.out.println("Tutaj sklonowana owca: ");
        System.out.println(clonedSheep);
    }
    
    private static void KsztaltyMain()
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