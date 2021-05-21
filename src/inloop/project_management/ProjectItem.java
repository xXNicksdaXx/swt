package inloop.project_management;

public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        if(details == null) throw new NullPointerException("details cannot be null!");
        if(details.equals("")) throw new IllegalArgumentException("details cannot be empty!");
        this.details = details;
        if(rate <= 0) throw new IllegalArgumentException("rate should be positive!");
        this.rate = rate;
    }

    public void setDetails(String newDetails){
        if(newDetails == null) throw new NullPointerException("details cannot be null!");
        if(newDetails.equals("")) throw new IllegalArgumentException("details cannot be empty!");
        this.details = newDetails;
    }

    public long getCostEstimate(){
        double d = getTimeRequired() * rate;
        return (long) d + getMaterialCost();
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();
}
