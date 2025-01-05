package lldQuestions.stackOverflowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private int reputation;
    private List<Question>questions;
    private List<Answer>answers;
    private List<Comment>comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2; 

    public User(int id,String username,String email){
        this.id=id;
        this.username=username;
        this.email=email;
        this.reputation=0;
        this.questions=new ArrayList<>();
        this.answers=new ArrayList<>();
        this.comments=new ArrayList<>();
    }

    public void updateReputation(int value){
        reputation+=value;
    }

    public Question askQuestion(String title,String content,List<String>tags){
        Question question=new Question(this,title,content,tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question,String content){
        Answer answer=new Answer(this,content, question);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable,String content){
        Comment comment=new Comment(this, content);
        commentable.addComment(comment);
        comments.add(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public int getId() {return id;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public int getReputation() {return reputation;}
    public List<Question> getQuestions() {return new ArrayList<>(questions);}
    public List<Answer> getAnswers() {return new ArrayList<>(answers);}
    public List<Comment> gComments() {return new ArrayList<>(comments);}
}
