package lldQuestions.taskManagerDesign;

import java.util.Date;

public class Task{
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskStatus status;
    private User userAssigned;

    public Task(String id,String title,String description,Date duedate,Integer priority,User userAssigned){
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.userAssigned=userAssigned;
        this.status=TaskStatus.PENDING;
        this.dueDate=duedate;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public int getPriority(){
        return priority;
    }

    public User getUserAssigned(){
        return userAssigned;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setPriority(Integer priority){
        this.priority=priority;
    }

    public void setStatus(TaskStatus status){
        this.status=status;
    }

    public void setDueDate(Date dueDate){
        this.dueDate=dueDate;
    }
}