package io.model;

public class Car 
{
    private CarType car_type;
    private Engine engine;
    private Transmission transmission;
    private String color;

    public Car(CarType car_type, Engine engine, Transmission transmission, String color) 
    {
        this.car_type = car_type;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
    }

    public CarType getCar_type() 
    {
        return car_type;
    }

    public Engine getEngine() 
    {
        return engine;
    }

    public String getColor() 
    {
        return color;
    }

    public Transmission getTransmission() 
    {
        return transmission;
    }
}
