package inloop.enterprise_node;

import java.util.Set;

public abstract class AbstractUnit extends AbstractEnterpriseUnit{
    private Set<AbstractEnterpriseUnit> childNodes;

    public AbstractUnit(String name) {
        super(name);
    }

    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode == null) throw new NullPointerException("childNode cannot be null!");
        if(childNodes.contains(childNode)) return false;

        if(this instanceof Holding){
            if (!(childNode instanceof Company)) throw new IllegalArgumentException("holding must consist of companies!");
            childNodes.add(childNode);
            return true;
        }

        else if(this instanceof Company){
            if (!(childNode instanceof Division)) throw new IllegalArgumentException("company must consist of divisions!");
            childNodes.add(childNode);
            return true;
        }

        else if(this instanceof Division){
            if (!(childNode instanceof Team)) throw new IllegalArgumentException("division must consist of teams!");
            childNodes.add(childNode);
            return true;
        }
        return false;
    }

    public boolean remove(AbstractEnterpriseUnit childNode){
        if(childNode == null) throw new NullPointerException("childNode cannot be nulL!");

        if(!(childNodes.contains(childNode))) return false;
        else {
            childNodes.remove(childNode);
            return true;
        }
    }

    public Set<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }
}
