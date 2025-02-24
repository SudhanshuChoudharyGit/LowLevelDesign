package System;

import Abstracts.Vehicle;
import Entites.ParkingLevel;

import java.util.ArrayList;
import java.util.List;

//Singleton pattern is used to access instance of parkinglot (Double-Checked Locking)
public class ParkingLot {
    private static ParkingLot Instance;
    private final List<ParkingLevel> parkingLevelList;
    private static final Object lock = new Object();

    private ParkingLot()
    {
        this.parkingLevelList = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance()
    {
        if(Instance == null)
        {
            synchronized (lock){
                if(Instance == null)
                {
                    Instance = new ParkingLot();
                }
            }
        }
        return Instance;
    }

    public void addParkingLevel(ParkingLevel level)
    {
        this.parkingLevelList.add(level);
    }


    public boolean park(Vehicle vehicle)
    {
        for(ParkingLevel level : parkingLevelList)
        {
            if(level.park(vehicle)==true)
            {
                System.out.println("Vehicle: "+vehicle.getNumberPlate()+" is parked successfully.");
                return true;
            }
        }
        System.out.println("Cannot park: No parking spots are available right now.");
        return false;
    }

    public boolean unpark(Vehicle vehicle)
    {
        for(ParkingLevel level : parkingLevelList)
        {
            if(level.unPark(vehicle))
            {
                System.out.println("Vehicle: "+vehicle.getNumberPlate()+" is unparked successfully.");
                return true;
            }
        }
        System.out.println("No such vehicle found");
        return false;
    }

    public void getAvailability()
    {
        for(ParkingLevel level : parkingLevelList)
        {
            System.out.println("Availability for level: "+level.getFloor());
            level.getAvailabilityForParkingLevel();
        }
    }
}
