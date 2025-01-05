package lldQuestions.stackOverflowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable,Commentable{
    private int id;
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted;
    private Date creationDate;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User author,String content,Question question){
        this.id=generateId();
        this.content=content;
        this.author=author;
        this.question=question;
        this.creationDate=new Date();
        this.comments=new ArrayList<>();
        this.votes=new ArrayList<>();
        this.isAccepted=false;
    }

    private int generateId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public void vote(User user,int value){
        if(value!=-1 && value!=1){
            System.out.println("Please enter a valid vote.");
        }
        votes.removeIf(v->v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateReputation(value*10);
    }

    @Override
    public int getVoteCnt(){
        int totalVotes=0;
        for(Vote vote:votes){
            totalVotes+=vote.getValue();
        }
        return totalVotes;
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments(){
        return new ArrayList<>(comments);
    }

    public void markAccepted(){
        if(isAccepted){
            System.out.println("This answer is already accepted.");
        }
        isAccepted=true;
        author.updateReputation(15);
    }

    public int getId() {return id;}
    public User getAuthor() {return author;}
    public Question getQuestion() {return question;}
    public String getContent() {return content;}
    public Date getCreationDate() {return creationDate;}
    public boolean getIsAccepted() {return isAccepted;}
}
