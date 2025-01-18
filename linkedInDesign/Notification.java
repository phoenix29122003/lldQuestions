package lldQuestions.linkedInDesign;

import java.sql.Timestamp;

public class Notification{
    private String id;
    private User user;
    private NotificationType type;
    private String content;
    private Timestamp timeStamp;

    public Notification(String id,User user,NotificationType type,String content,Timestamp timeStamp){
        this.id=id;
        this.user=user;
        this.type=type;
        this.content=content;
        this.timeStamp=timeStamp;
    }

    public String getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public NotificationType getNotificationType(){
        return type;
    }

    public String getContent(){
        return content;
    }

    public Timestamp getTimeStamp(){
        return timeStamp;
    }
}