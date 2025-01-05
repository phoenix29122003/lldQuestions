package lldQuestions.stackOverflowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable {
    private int id;
    private String title;
    private String content;
    private User author;
    private Date creationTime;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;

    public Question(User author, String title,String content,List<String> tagNames){
        this.id=generateId();
        this.title=title;
        this.content=content;
        this.author=author;
        this.creationTime=new Date();
        this.answers=new ArrayList<>();
        this.comments=new ArrayList<>();
        this.votes=new ArrayList<>();
        this.tags=new ArrayList<>();
        for(String tagName:tagNames){
            this.tags.add(new Tag(tagName));
        }
    }

    private int generateId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            answers.add(answer);
        }
    }

    @Override
    public void vote(User user,int value){
        if(value!=-1 && value!=1){
            System.out.println("Please enter a valid vote.");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateReputation(value*5);
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

    public int getId() {return id;}
    public User getAuthor() {return author;}
    public String getTitle() {return title;}
    public String getContent() {return content;}
    public Date getCreationDate() {return creationTime;}
    public List<Answer> getAnswers() {return new ArrayList<>(answers);}
    public List<Tag> getTags() {return new ArrayList<>(tags);}

}
