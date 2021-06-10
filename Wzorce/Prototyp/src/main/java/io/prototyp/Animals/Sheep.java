package io.prototyp.Animals;

import java.util.Objects;

public class Sheep implements Animal{
    private String color;
    private String name;

    public Sheep(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public Animal makeClone(){
        System.out.println("Robimy owcę. Proces klonowania rozpoczęty.");
        Sheep sheepObject = null;
        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Proba klonowania nie powiodła się. Obiekt nie żyje.");
            e.printStackTrace();
        }
        return sheepObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(color, sheep.color) && Objects.equals(name, sheep.name);
    }

    @Override
    public String toString() {
        return "--- Cześć! To ja, owca, " +
                "mam kolor " + color + ' ' +
                "i imię: " + name + '.';
    }
}
