package inloop.project_management;

import java.time.LocalDate;
import java.util.*;

public class Project {

    private class Adapter implements IProject {

        public Adapter(String name, String description, double rate){
            if(name == null) throw new NullPointerException("name cannot be null!");
            if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
            if(description == null) throw new NullPointerException("description cannot be null!");
            if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");
            setTask(new Task(name, description, rate));
        }

        @Override
        public void setTask(Task newTask){
            mainTask = newTask;
        }

        @Override
        public double getDuration(){
            return mainTask.getTimeRequired();
        }

        @Override
        public long getTotalCost(){
            return mainTask.getMaterialCost();
        }

        @Override
        public List<Deliverable> getDeliverables() { return mainTask.allDeliverables(); }
    }

    private String name;
    private String description;
    private Task mainTask;

    public Project(String name, String description, double rate){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");
        this.description = description;
        this.mainTask = new Task(name, description, rate);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Task newTask){
        this.mainTask = newTask;
    }

    public double getDuration(){
        return mainTask.getTimeRequired();
    }

    public long getTotalCost(){
        return mainTask.getMaterialCost();
    }

    public Map<LocalDate, List<Deliverable>> allDeliverables(){
        Map<LocalDate, List<Deliverable>> echo = new HashMap<>();
        List<Deliverable> extra = mainTask.allDeliverables();
        for (Deliverable d : extra) {
            LocalDate current = d.getDate();
            List<Deliverable> currentDate;
            if (echo.containsKey(current)) {
                // date already in list
                currentDate = echo.get(current);
            } else {
                // new date-entry
                currentDate = new LinkedList<>();
            }
            currentDate.add(d);
            echo.put(current, currentDate);
        }
        return echo;
    }
}
