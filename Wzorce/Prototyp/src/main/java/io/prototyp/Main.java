package io.prototyp;

public class Main {

    public static void main(String[] args) {
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
}