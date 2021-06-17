package inloop.enterprise_node;

import java.util.*;

public class StaffMember implements EnterpriseNode, Comparable<StaffMember>{
    private String name;
    private String job;
    private SortedSet<StaffMember> directSubordinates;

    public StaffMember(String name, String job){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        if(job == null) throw new NullPointerException("job cannot be null!");
        if(job.equals("")) throw new IllegalArgumentException("job cannot be empty!");
        this.job = job;
        directSubordinates = new TreeSet<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public boolean addDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException("subordinate cannot be null!");
        if(directSubordinates.contains(subordinate)) return false;
        else{
            directSubordinates.add(subordinate);
            return true;
        }
    }

    public boolean removeDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException("subordinate cannot be null!");
        if(!(directSubordinates.contains(subordinate))) return false;
        else {
            directSubordinates.remove(subordinate);
            return true;
        }
    }

    public SortedSet<StaffMember> getDirectSubordinates() {
        if(directSubordinates.size() == 0) return new TreeSet<>();

        SortedSet<StaffMember> allSubordinates = new TreeSet<>();
        for(StaffMember sm : directSubordinates){
            allSubordinates.add(sm);
            allSubordinates.addAll(sm.getDirectSubordinates());
        }
        return allSubordinates;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(StaffMember o) {
        String name1 = this.toString();
        String name2 = o.toString();
        return name1.compareTo(name2);
    }
}