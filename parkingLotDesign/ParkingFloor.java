package lldQuestions.parkingLotDesign;

import java.util.*;

import lldQuestions.parkingLotDesign.vehicleType.Vehicle;
import lldQuestions.parkingLotDesign.vehicleType.VehicleType;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot>parkingSpotList;

    public ParkingFloor(int floorNumber,int totalSpots){
        this.floorNumber=floorNumber;
        this.parkingSpotList=new ArrayList<>(totalSpots);
        double bikeRatio=0.5;
        double carRatio=0.4;
        int numberOfBikes=(int)(bikeRatio*totalSpots);
        int numberOfCars=(int)(carRatio*totalSpots);

        for(int i=1;i<=numberOfBikes;i++){
            parkingSpotList.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for(int i=numberOfBikes+1;i<=(numberOfBikes+numberOfCars);i++){
            parkingSpotList.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for(int i=(numberOfBikes+numberOfCars+1);i<=totalSpots;i++){
            parkingSpotList.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:parkingSpotList){
            if(spot.isAvailable() && spot.getVehicleType()==vehicle.getVehicleType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:parkingSpotList){
            if(!spot.isAvailable() && spot.getParkedVehicle()==vehicle){
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Floor Number: "+floorNumber);
        for(ParkingSpot spot:parkingSpotList){
            if (spot.isAvailable()) {
                System.out.println("Spot Number: " + spot.getSpotNumber() + 
                    " is Available for " + spot.getVehicleType());
            } else {
                System.out.println("Spot Number: " + spot.getSpotNumber() + 
                    " is Occupied by " + spot.getParkedVehicle().getVehicleType());
            }
        }
    }
}
