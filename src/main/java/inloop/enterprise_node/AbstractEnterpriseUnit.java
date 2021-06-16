package inloop.enterprise_node;

public abstract class AbstractEnterpriseUnit implements EnterpriseNode{
    private String name;

    public AbstractEnterpriseUnit(String name){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
