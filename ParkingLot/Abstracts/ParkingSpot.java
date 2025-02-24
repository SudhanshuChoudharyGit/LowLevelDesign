package Abstracts;

import java.util.List;
import java.util.Set;

import Constants.VehicleType;

public abstract class ParkingSpot {
    private int spotNumber;
    private Set<VehicleType> supportedVehicleTypes;
    private Vehicle parkedVehicle;


    public ParkingSpot(int spotNumber,Set<VehicleType> supportedVehicleTypes)
    {
        this.spotNumber = spotNumber;
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public synchronized void park(Vehicle vehicle)
    {
        if(this.isAvailable() && this.supportedVehicleTypes.contains(vehicle.getType()))
        {
            this.parkedVehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("Spot not available or Invalid vehicle type");
        }
    }

    public synchronized void unpark()
    {
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return this.parkedVehicle == null;
    }

    public Set<VehicleType> getSupportedVehicleTypes() {
        return this.supportedVehicleTypes;
    }

    public Vehicle getParkedVehicle() {
        return this.parkedVehicle;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

}