package inloop.renovation_project;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StructuredObject extends RenovationObject {
    private Set<RenovationObject> parts;

    public StructuredObject(){
        parts = new HashSet<>();
    }

    public void add(RenovationObject renovationObject){

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Map<String, Integer> addMaterialRequirements() {
        return null;
    }
}
