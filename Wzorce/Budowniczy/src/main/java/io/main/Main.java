package io.main;

import io.budowniczy.CarBuilder;
import io.budowniczy.CarManualBuilder;
import io.model.Car;
import io.model.Manual;

public class Main 
{
    public static void main(String[] args) 
    {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        CarManualBuilder manualBuilder = new CarManualBuilder();
        
        
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Zbudowany pojazd:\n" + car.getCar_type());

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nZbudowany manual:\n" + carManual.printManual());
        
        
        System.out.println("\n");
        
        
        director.constructCityCar(builder);
        Car car_ = builder.getResult();
        System.out.println("Zbudowany pojazd:\n" + car_.getCar_type());

        director.constructCityCar(manualBuilder);
        Manual carManual_ = manualBuilder.getResult();
        System.out.println("\nZbudowany manual:\n" + carManual_.printManual());
    }
}
