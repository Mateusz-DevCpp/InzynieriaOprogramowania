package io.budowniczy;

import io.model.*;

public interface Builder 
{
    void setCarType(CarType car_type);
    void setEngine(Engine engine);
    void setColor(String color);
    void setTransmission(Transmission transmission);
}
