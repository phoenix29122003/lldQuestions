package lldQuestions.pubSystemDesign;

public class Message {
    private String content;

    public Message(String content){
        this.content=content;
    }

    public String getMessage(){
        return content;
    }
}
