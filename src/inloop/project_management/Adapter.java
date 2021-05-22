package inloop.project_management;

import java.util.List;

public class Adapter implements IProject {
    private String name;
    private String description;
    private Task mainTask;

    public Adapter(String name, String description, double rate){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");
        this.description = description;
        this.mainTask = new Task(name, description, rate);
    }

    @Override
    public void setTask(Task newTask){
        if(newTask == null) throw new NullPointerException("newTask cannot be null!");
        mainTask = newTask;
    }

    @Override
    public double getDuration(){
        return mainTask.getTimeRequired();
    }

    @Override
    public long getTotalCost(){
        return mainTask.getCostEstimate();
    }

    @Override
    public List<Deliverable> getDeliverables() { return mainTask.allDeliverables(); }
}
