package lldQuestions.libraryManagementSystemDesign;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String contactInfo;
    private List<Book> books;

    public Member(String memberId,String name,String contactInfo){
        this.memberId=memberId;
        this.name=name;
        this.contactInfo=contactInfo;
        this.books=new ArrayList<>();
    }

    public String getMemberId(){
        return memberId;
    }

    public String getName(){
        return name;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public List<Book> getBooks(){
        return books;
    }
}
