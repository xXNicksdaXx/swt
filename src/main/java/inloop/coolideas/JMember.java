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
    }

    public void unsubscribe(JTopic topic){
        if (topic == null) throw new NullPointerException("topic cannot be null!");
        topics.remove(topic);
    }

    @Override
    public void update(JContent content) {
        System.out.println("The topic <id> has been updated!");
    }

    public Set<JTopic> getTopics() {
        return topics;
    }
}
