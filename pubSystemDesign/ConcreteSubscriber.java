package lldQuestions.pubSystemDesign;

public class ConcreteSubscriber implements Subscriber {
    private String name;

    public ConcreteSubscriber(String name){
        this.name=name;
    }

    @Override
    public void notifyMessage(Message message){
        System.out.println("Subscriber "+name+" received "+message.getMessage());
    }
}
