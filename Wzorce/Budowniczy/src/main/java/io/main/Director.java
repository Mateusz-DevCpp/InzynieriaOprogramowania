package io.main;

import io.budowniczy.Builder;
import io.model.CarType;
import io.model.Engine;
import io.model.Transmission;

public class Director 
{
    public void constructSportsCar(Builder builder) 
    {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setEngine(new Engine(250, 3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setColor("Zielony");
    }

    public void constructCityCar(Builder builder) 
    {
        builder.setCarType(CarType.CITY_CAR);
        builder.setEngine(new Engine(80, 1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setColor("Bialy");
    }

    public void constructSUV(Builder builder) 
    {
        builder.setCarType(CarType.SUV);
        builder.setEngine(new Engine(170, 2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setColor("Czarny");
    }
}
