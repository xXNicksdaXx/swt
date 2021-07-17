package inloop.coolideas;

import java.util.HashSet;
import java.util.Set;

public class JMember implements ContentObserver{
    private Set<JTopic> topics;

    public JMember(){
        topics = new HashSet<>();
    }

    public void subscribe(JTopic topic){
        if (topic == null) throw new NullPointerException("topic cannot be null!");
        topics.add(topic);
        topic.addObserver(this);
    }

    public void unsubscribe(JTopic topic){
        if (topic == null) throw new NullPointerException("topic cannot be null!");
        topic.removeObserver(this);
        topics.remove(topic);
    }

    @Override
    public void update(JContent content) {
        for (JTopic topic : topics){
            if(topic == content) System.out.println("The topic "+ topic.getId() +" has been updated!"); ;
        }
    }

    public Set<JTopic> getSubscribedTopics() {
        return topics;
    }
}