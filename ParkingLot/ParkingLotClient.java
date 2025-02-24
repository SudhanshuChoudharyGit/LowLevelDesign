import Abstracts.Vehicle;
import Entites.Bike;
import Entites.Car;
import Entites.ParkingLevel;
import Entites.Truck;
import System.ParkingLot;

public class ParkingLotClient {
    public static void main() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addParkingLevel(new ParkingLevel(1, 100));
        parkingLot.addParkingLevel(new ParkingLevel(2, 100));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Bike("M1234");
        Vehicle car2 = new Car("ZZZ12");

        // Park vehicles
        parkingLot.park(car);
        parkingLot.park(truck);
        parkingLot.park(motorcycle);
        parkingLot.unpark(car);
        parkingLot.unpark(car);
        parkingLot.unpark(car2);
        parkingLot.park(car2);
    }
}

