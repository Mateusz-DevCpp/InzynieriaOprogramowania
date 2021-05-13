package io.model;

public class Manual 
{
    private CarType car_type;
    private Engine engine;
    private Transmission transmission;
    private String color;

    public Manual(CarType car_type, Engine engine, Transmission transmission, String color) 
    {
        this.car_type = car_type;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
    }

    public String printManual() 
    {
        String result = "";
        
        result += "Pojazd:\n";
        result += "typ: " + car_type + "\n";
        result += "engine: " + engine.toString() + "\n";
        result += "skrzynia: " + transmission + "\n";
        result += "kolor: " + color + "\n";
        
        return result;
    }
}
