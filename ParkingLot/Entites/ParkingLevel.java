package Entites;

import Abstracts.ParkingSpot;
import Abstracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private int floor;
    private List<ParkingSpot> parkingSpotList;


    public ParkingLevel(int floor,int numSpots)
    {
        this.floor = floor;
        //assuming 50:30:20 for CAR:BIKE:TRUCK
        int carSpots = (int) (numSpots*0.5);
        int bikeSpots = (int) (numSpots*0.3);

        parkingSpotList = new ArrayList<>();
        for(int i = 1;i<=carSpots;i++)  parkingSpotList.add(new CarParkingSpot(i));
        for(int i = carSpots+1;i<=carSpots+bikeSpots;i++)  parkingSpotList.add(new BikeParkingSpot(i));
        for(int i = carSpots + bikeSpots + 1;i<=numSpots;i++)  parkingSpotList.add(new TruckParkingSpot(i));
    }

    public synchronized boolean park(Vehicle vehicle)
    {
        for(ParkingSpot spot: parkingSpotList)
        {
            if(spot.isAvailable() && spot.getSupportedVehicleTypes().contains(vehicle.getType()))
            {
                try
                {
                    spot.park(vehicle);
                    return true;
                }
                catch (Exception e)
                {
                    System.out.println("Cannot park, Exception: "+e.getMessage());
                }
            }
        }
        return false;
    }

    public synchronized boolean unPark(Vehicle vehicle)
    {
        for(ParkingSpot parkingSpot : parkingSpotList)
        {
            if(parkingSpot.getParkedVehicle() == vehicle)
            {
                parkingSpot.unpark();
                return true;
            }
        }
        return false;
    }

    public boolean getAvailabilityForParkingSpot(ParkingSpot parkingSpot)
    {
        return parkingSpot.isAvailable();
    }

    public void getAvailabilityForParkingLevel()
    {
        for(ParkingSpot parkingSpot : parkingSpotList)
        {
            System.out.println("Parking spot: Level"+ floor + parkingSpot.getSpotNumber() + ": "+ ((parkingSpot.isAvailable()) ? "is Available" : "Occupied by " + parkingSpot.getParkedVehicle()));
        }
    }

    public int getFloor()
    {
        return floor;
    }
}
