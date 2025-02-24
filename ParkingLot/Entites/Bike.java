package Entites;

import Abstracts.Vehicle;
import Constants.VehicleType;

public class Bike extends Vehicle {
    public Bike(String numberPlate) {
        super(numberPlate, VehicleType.BIKE);
    }
}
