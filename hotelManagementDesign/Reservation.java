package lldQuestions.hotelManagementDesign;

import java.time.LocalDate;

public class Reservation {
    private String id;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(String id,Guest guest,Room room,LocalDate checkInDate,LocalDate checkOutDate){
        this.id=id;
        this.guest=guest;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.status=ReservationStatus.CONFIRMED;
    }

    public void cancel(){
        if(status==ReservationStatus.CONFIRMED){
            status=ReservationStatus.CANCELLED;
            room.checkOut();
        }
        else{
            System.out.println("Reservation is not confirmed");
        }
    }

    public String getId(){
        return id;
    }

    public Guest getGuest(){
        return guest;
    }

    public Room getRoom(){
        return room;
    }

    public LocalDate getCheckInDate(){
        return checkInDate;
    }

    public LocalDate getCheckOutDate(){
        return checkOutDate;
    }

    public ReservationStatus getReservationStatus(){
        return status;
    }

}
