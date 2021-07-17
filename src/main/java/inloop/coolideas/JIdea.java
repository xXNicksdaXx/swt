package inloop.coolideas;

import java.util.LinkedList;
import java.util.List;

public class JIdea extends JContent{
    private List<JAttachment> attachments;
    private JState state;

    public JIdea(String title, String description) {
        super(title, description);
        attachments = new LinkedList<>();
        state = new Draft();
    }

    public void discuss(String text){
        state.discuss(text);
    }

    public void evaluate(JValuation valuation){
        state.evaluate(valuation);
    }

    public void hold(){
        state.hold();
    }

    public void release(){
        state.release();
    }

    public void decline(){
        state.decline();
    }

    public boolean isDeclined(){
        return state instanceof DeclinedIdea;
    }

    public boolean isReleased(){
        return state instanceof ReleasedIdea;
    }

    public String getCurrentDiscussion(){
        return state.getCurrentDiscussion();
    }

    public JValuation getValuation(){
        return state.getValuation();
    }

    public void addAttachment(JAttachment attachment){
        if(attachment == null) throw new NullPointerException("attachment cannot be null!");
        attachments.add(attachment);
    }

    public List<JAttachment> getAttachments(){
        return attachments;
    }

    public boolean removeAttachment(JAttachment attachment){
        if(attachment == null) throw new NullPointerException("attachment cannot be null!");
        return attachments.remove(attachment);
    }

    @Override
    public String toString() {
        return "Idea: "+getTitle()+"\n"+getDescription();
    }

    //STATE PATTERN

    private abstract class JState{
        private JValuation valuation;
        private String currentDiscussion;

        public void discuss(String text){
            throw new IllegalStateException("discuss is not implemented by current state!");
        }

        public void evaluate(JValuation valuation){
            throw new IllegalStateException("evaluate is not implemented by current state!");

        }

        public void hold(){
            throw new IllegalStateException("hold is not implemented by current state!");
        }

        public void release(){
            throw new IllegalStateException("release is not implemented by current state!");
        }

        public void decline(){
            throw new IllegalStateException("decline is not implemented by current state!");
        }

        public String getCurrentDiscussion() {
            return currentDiscussion;
        }

        public void setCurrentDiscussion(String currentDiscussion) {
            if(currentDiscussion == null) throw new NullPointerException("currentDiscussion cannot be null!");
            if(currentDiscussion.equals("")) throw new IllegalArgumentException("currentDiscussion cannot be empty!");
            this.currentDiscussion = currentDiscussion;
        }

        public JValuation getValuation() {
            return valuation;
        }

        public void setValuation(JValuation valuation) {
            if(valuation == null) throw new NullPointerException("valuation cannot be null!");
            this.valuation = valuation;
        }
    }

    private class Draft extends JState{
        @Override
        public void hold() {
            state = new OpenDraft();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }

    private class OpenDraft extends JState{
        @Override
        public void discuss(String text) {
            state.setCurrentDiscussion(text);
        }

        @Override
        public void evaluate(JValuation valuation) {
            state.setValuation(valuation);
        }

        @Override
        public void hold() {
            state = new ApprovedIdea();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }

    private class ApprovedIdea extends JState{
        @Override
        public void release() {
            state = new ReleasedIdea();
        }
    }

    private class ReleasedIdea extends JState{
    }

    private class DeclinedIdea extends JState{
    }
}
