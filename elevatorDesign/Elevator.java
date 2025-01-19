package lldQuestions.elevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int id;
    private int capacity;
    private int currentFloor;
    private Direction direction;
    private List<Request> requests;

    public Elevator(int id,int capacity){
        this.id=id;
        this.capacity=capacity;
        this.currentFloor=1;
        this.direction=Direction.UP;
        this.requests=new ArrayList<>();
    }

    public synchronized void addRequest(Request request) {
        if (requests.size() < capacity) {
            requests.add(request);
            notifyAll(); 
            System.out.println("Request added to Elevator " + id + ": " + request.getDestinationFloor());
        } else {
            System.out.println("Elevator " + id + " is full. Request not added.");
        }
    }
    
    public synchronized Request getNextRequest() {
        if (!requests.isEmpty()) {
            return requests.remove(0);
        }
        return null;
    }
    

    public void processRequests() {
        synchronized (this) {
            while (true) {
                while (requests.isEmpty()) {
                    try {
                        wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Request request = getNextRequest();
                processRequest(request);
            }
        }
    }
    

    private void processRequest(Request request){
        int destinationFloor=request.getDestinationFloor();
        if(currentFloor<destinationFloor){
            direction=Direction.UP;
            for(int i=currentFloor;i<=destinationFloor;i++){
                currentFloor=i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
            }
        }
        else if(currentFloor>destinationFloor){
            direction=Direction.DOWN;
            for(int i=currentFloor;i>=destinationFloor;i--){
                currentFloor=i;
                System.out.println("Elevator " + id + " reached floor " + currentFloor);
            }
        }
        else {
            System.out.println("We are already on desired floor");
        }
    }

    public void run() {
        processRequests();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
