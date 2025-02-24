package Entites;

import Abstracts.ParkingSpot;
import Constants.VehicleType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(int id) {
        HashSet<VehicleType> supportedVehicleTypes = new HashSet<>(List.of(new VehicleType[]{VehicleType.TRUCK, VehicleType.CAR, VehicleType.BIKE}));
        super(id, supportedVehicleTypes);
    }
}
