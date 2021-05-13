package io.budowniczy;

import io.model.CarType;
import io.model.Engine;
import io.model.Manual;
import io.model.Transmission;

public class CarManualBuilder implements Builder
{
    private CarType car_type;
    private Engine engine;
    private Transmission transmission;
    private String color;
    
    public Manual getResult() 
    {
        return new Manual(car_type, engine, transmission, color);
    }

    @Override
    public void setCarType(CarType car_type) 
    {
        this.car_type = car_type;
    }

    @Override
    public void setEngine(Engine engine) 
    {
        this.engine = engine;
    }

    @Override
    public void setColor(String color) 
    {
        this.color = color;
    }

    @Override
    public void setTransmission(Transmission transmission) 
    {
        this.transmission = transmission;
     }
}
