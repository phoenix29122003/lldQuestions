package lldQuestions.elevatorDesign;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.RC2ParameterSpec;

public class ElevatorController {
    private List<Elevator>elevators;

    public ElevatorController(int numberOfElevator, int capacity) {
        this.elevators = new ArrayList<>();
        for (int i = 1; i <= numberOfElevator; i++) {
            Elevator elevator = new Elevator(i, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start(); 
        }
    } 

    public void requestElevator(int sourceFloor,int destinationFloor){
        Elevator optimalElevator=getOptimalElevator(sourceFloor,destinationFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }

    public Elevator getOptimalElevator(int sourceFloor,int destinationFloor){
        int minDis=Integer.MAX_VALUE;
        Elevator optimalElevator=null;
        for(Elevator elevator:elevators){
            int currentFloor=elevator.getCurrentFloor();
            int diff=Math.abs(currentFloor-sourceFloor);
            if(diff<minDis){
                optimalElevator=elevator;
                minDis=diff;
            }
        }
        return optimalElevator;
    }
}
