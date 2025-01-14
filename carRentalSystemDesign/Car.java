package lldQuestions.carRentalSystemDesign;

public class Car {
    private String make;
    private String model;
    private Integer year;
    private String licensePlate;
    private double rentalPricePerDay;
    private boolean isAvailable;

    public Car(String make,String model,Integer year,String licensePlate,double rentalPricePerDay){
        this.make=make;
        this.model=model;
        this.year=year;
        this.licensePlate=licensePlate;
        this.rentalPricePerDay=rentalPricePerDay;
        this.isAvailable=true;
    }

    public double getRentalPricePerDay(){
        return rentalPricePerDay;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public Integer getYear(){
        return year;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable){
        this.isAvailable=isAvailable;
    }
}