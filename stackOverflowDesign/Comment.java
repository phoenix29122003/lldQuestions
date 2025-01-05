package lldQuestions.stackOverflowDesign;

import java.util.Date;

public class Comment{
    private int id;
    private String content;
    private User author;
    private Date creationdate;

    public Comment(User author,String content){
        this.id=generateId();
        this.content=content;
        this.author=author;
        this.creationdate= new Date();
    }

    private int generateId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public User getAuthor() {return author;}
    public Date getCreationData() {return creationdate;}
}
