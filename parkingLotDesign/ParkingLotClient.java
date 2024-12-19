package lldQuestions.parkingLotDesign;

import lldQuestions.parkingLotDesign.vehicleType.Car;
import lldQuestions.parkingLotDesign.vehicleType.Bike;
import lldQuestions.parkingLotDesign.vehicleType.Truck;
import lldQuestions.parkingLotDesign.vehicleType.Vehicle;

public class ParkingLotClient {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.addFloor(new ParkingFloor(1, 10));
        parkingLot.addFloor(new ParkingFloor(2, 10));

        Vehicle car = new Car("CAR123");
        Vehicle bike = new Bike("BIKE123");
        Vehicle truck = new Truck("TRUCK123");

        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(truck);
        parkingLot.unParkVehicle(bike);
        parkingLot.unParkVehicle(car);

        parkingLot.displayAvailability();
    }
}
