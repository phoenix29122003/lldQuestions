package lldQuestions.hotelManagementDesign;

public class Guest{
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public Guest(String id,String name,String email,String phoneNumber){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}