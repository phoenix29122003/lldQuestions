package lldQuestions.parkingLotDesign;

import lldQuestions.parkingLotDesign.vehicleType.Vehicle;
import lldQuestions.parkingLotDesign.vehicleType.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber,VehicleType vehicleType){
        this.spotNumber=spotNumber;
        this.vehicleType=vehicleType;
    }

    public boolean isAvailable(){
        return parkedVehicle==null;
    }

    public void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getVehicleType()==vehicleType){
            parkedVehicle=vehicle;
        }
        else{
            System.out.println("Sorry, we cannot park vehicle");
        }
    } 

    public void unParkVehicle(){
        parkedVehicle=null;
    } 


    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

    public int getSpotNumber(){
        return spotNumber;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
