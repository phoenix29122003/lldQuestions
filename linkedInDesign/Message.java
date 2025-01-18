package lldQuestions.linkedInDesign;

import java.sql.Timestamp;

public class Message {
    private String id;
    private User sender;
    private User receiver;
    private String content;
    private Timestamp timeStamp;

    public Message(String id,User sender,User receiver,String content,Timestamp timeStamp){
        this.id=id;
        this.sender=sender;
        this.receiver=receiver;
        this.content=content;
        this.timeStamp=timeStamp;
    }
}
