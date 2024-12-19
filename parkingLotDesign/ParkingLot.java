package lldQuestions.parkingLotDesign;

import java.util.ArrayList;
import java.util.List;

import lldQuestions.parkingLotDesign.vehicleType.Vehicle;

public class ParkingLot {
    private List<ParkingFloor>parkingFloorList;
    public ParkingLot(){
        parkingFloorList=new ArrayList<>();
    }

    public void addFloor(ParkingFloor floor){
        parkingFloorList.add(floor);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor:parkingFloorList){
            if(floor.parkVehicle(vehicle)){
                System.out.println("Vehicle Parked Successfully");
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(ParkingFloor floor:parkingFloorList){
            if(floor.unParkVehicle(vehicle)){
                System.out.println("Vehicle Unparked Successfully");
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(ParkingFloor floor:parkingFloorList){
            floor.displayAvailability();
        }
    }
}
