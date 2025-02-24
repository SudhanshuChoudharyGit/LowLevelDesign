package Entites;

import Abstracts.Vehicle;
import Constants.VehicleType;

public class Truck extends Vehicle
{
    public Truck(String numberPlate) {
        super(numberPlate, VehicleType.TRUCK);
    }
}