package Entites;

import Abstracts.ParkingSpot;
import Constants.VehicleType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int id) {
        HashSet<VehicleType> supportedVehicleTypes = new HashSet<>(List.of(new VehicleType[]{VehicleType.CAR, VehicleType.BIKE}));
        super(id, supportedVehicleTypes);
    }
}
