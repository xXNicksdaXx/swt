package inloop.renovation_project;

import java.util.Map;

public abstract class RenovationObject {
    public abstract double getPrice();
    public abstract Map<String, Integer> addMaterialRequirements();
}