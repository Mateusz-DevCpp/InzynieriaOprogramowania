package io.model;

public class Engine 
{
    private final double volume;
    private double mileage;
    private boolean started;
    private int power;

    public Engine(int power, double volume, double mileage) 
    {
        this.power = power;
        this.volume = volume;
        this.mileage = mileage;
    }

    public int getPower() 
    {
        return power;
    }
    
    public void on() 
    {
        started = true;
    }

    public void off() 
    {
        started = false;
    }

    public boolean isStarted() 
    {
        return started;
    }

    public void go(double mileage) 
    {
        if (started) 
        {
            this.mileage += mileage;
        } 
        else 
        {
            System.err.println("Wlacz silnik zanim zrobisz go()!");
        }
    }

    public double getVolume() 
    {
        return volume;
    }

    public double getMileage() 
    {
        return mileage;
    }

    @Override
    public String toString() 
    {
        return "Engine{" + "volume=" + volume + ", power=" + power + '}';
    }
    
}
