package lldQuestions.hotelManagementDesign;

public class Room {
    private String id;
    private RoomType type;
    private RoomStatus status;
    private double price;

    public Room(String id,RoomType type,double price){
        this.id=id;
        this.type=type;
        this.status=RoomStatus.AVAILABLE;
        this.price=price;
    }

    public String getId(){
        return id;
    }

    public RoomStatus getStatus(){
        return status;
    }

    public RoomType getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    public void book(){
        if(status!=RoomStatus.AVAILABLE){
            System.out.println("The room is not available.");
        }
        else{
            status=RoomStatus.BOOKED;
        }
    }

    public void checkIn(){
        if(status!=RoomStatus.BOOKED){
            System.out.println("The room is not booked.");
        }
        else{
            status=RoomStatus.OCCUPIED;
        }
    }

    public void checkOut(){
        if(status!=RoomStatus.OCCUPIED){
            System.out.println("The room is not occupied.");
        }
        else{
            status=RoomStatus.AVAILABLE;
        }
    }
}
