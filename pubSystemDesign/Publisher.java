package lldQuestions.pubSystemDesign;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private Set<Topic>topics;

    public Publisher(){
        this.topics=new HashSet<>();
    }

    public void registerTopic(Topic topic){
        topics.add(topic);
    }

    public void publish(Topic topic,Message message){
        topic.publish(message);
    }
}
