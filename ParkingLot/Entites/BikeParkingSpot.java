package Entites;

import Abstracts.ParkingSpot;
import Constants.VehicleType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BikeParkingSpot extends ParkingSpot {

    public BikeParkingSpot(int id) {
        HashSet<VehicleType> supportedVehicleTypes = new HashSet<>(List.of(new VehicleType[]{VehicleType.BIKE}));
        super(id, supportedVehicleTypes);
    }
}
