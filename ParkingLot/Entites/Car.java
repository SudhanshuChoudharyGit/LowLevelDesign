package Entites;

import Abstracts.Vehicle;
import Constants.VehicleType;

public class Car extends Vehicle {

    public Car(String numberPlate) {
        super(numberPlate, VehicleType.CAR);
    }
}
