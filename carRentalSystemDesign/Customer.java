package lldQuestions.carRentalSystemDesign;

public class Customer {
    private String name;
    private String contactInfo;
    private String drivingLicenseNumber;

    public Customer(String name,String contactInfo,String drivingLicenseNumber){
        this.name=name;
        this.contactInfo=contactInfo;
        this.drivingLicenseNumber=drivingLicenseNumber;
    }

    public String getName(){
        return name;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public String getDrivingLicenseNumber(){
        return drivingLicenseNumber;
    }

}
