package inloop.project_management;

import java.util.*;

public class Task extends ProjectItem{
    private Set<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);
        projectItems = new HashSet<>();
    }

    @Override
    public double getTimeRequired() {
        double time = 0;
        for(ProjectItem pi : projectItems){
                time += pi.getTimeRequired();
            }
        return time;
    }

    @Override
    public long getMaterialCost() {
        long cost = 0;
        for(ProjectItem pi : projectItems){
            cost += pi.getMaterialCost();
        }
        return cost;
    }

    public void addProjectItem(ProjectItem pi){
        projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi){
        projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables(){
        List<Deliverable> deliverables = new LinkedList<>();
        for(ProjectItem pi : projectItems){
            if (pi instanceof Deliverable) {
                deliverables.add((Deliverable) pi);
            }
            else {
                Task ta = (Task) pi;
                List<Deliverable> extra = ta.allDeliverables();
                deliverables.addAll(extra);
            }
        }
        return deliverables;
    }
}
