package lldQuestions.airlineManagementSystemDesign.seat;

public class Seat {
    private String seatNumber;
    private SeatStatus seatStatus;
    private SeatType seatType;

    public Seat(String seatNumber,SeatType seatType){
        this.seatNumber=seatNumber;
        this.seatStatus=SeatStatus.AVAILABLE;
        this.seatType=seatType;
    }

    public void reserve(){
        this.seatStatus=SeatStatus.RESERVED;
    }

    public void release(){
        this.seatStatus=SeatStatus.AVAILABLE;
    }
}
