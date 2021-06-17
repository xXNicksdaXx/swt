package inloop.enterprise_node;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractUnit extends AbstractEnterpriseUnit{
    private Set<AbstractEnterpriseUnit> childNodes;

    public AbstractUnit(String name) {
        super(name);
        childNodes = new HashSet<>();
    }

    public boolean add(AbstractEnterpriseUnit childNode){
        if (childNode == null) throw new NullPointerException("childNode cannot be null!");

        if(this instanceof Holding){
            if (!(childNode instanceof Company)) throw new IllegalArgumentException("holding must consist of companies!");
            return childNodes.add(childNode);
        }

        else if(this instanceof Company){
            if (!(childNode instanceof Division)) throw new IllegalArgumentException("company must consist of divisions!");
            return childNodes.add(childNode);
        }

        else if(this instanceof Division){
            if (!(childNode instanceof Team)) throw new IllegalArgumentException("division must consist of teams!");
            return childNodes.add(childNode);
        }
        return false;
    }

    public boolean remove(AbstractEnterpriseUnit childNode){
        if(childNode == null) throw new NullPointerException("childNode cannot be nulL!");

        if(!(childNodes.contains(childNode))) return false;

        if(this instanceof Holding){
            if (!(childNode instanceof Company)) throw new IllegalArgumentException("holding must consist of companies!");
            childNodes.remove(childNode);
            return true;
        }

        if(this instanceof Company){
            if (!(childNode instanceof Division)) throw new IllegalArgumentException("company must consist of divisions!");
            childNodes.remove(childNode);
            return true;
        }

        if(this instanceof Division){
            if (!(childNode instanceof Team)) throw new IllegalArgumentException("division must consist of teams!");
            childNodes.remove(childNode);
            return true;
        }

        return true;
    }

    public Set<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }
}
