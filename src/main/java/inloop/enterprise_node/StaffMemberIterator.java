package inloop.enterprise_node;

import java.util.*;

public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember> {
    private SortedSet<StaffMember> allMembers;
    private boolean available = false;
    private StaffMember next;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        if(directSubordinates == null) throw new NullPointerException("directSubordinates cannot be null!");
        SortedSet<StaffMember> finalSet = new TreeSet<>();

        allMembers = finalSet;
    }

    private void findSubordinatesRecursively(StaffMember m){
        SortedSet<StaffMember> subordinates = new TreeSet<>();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public StaffMember next() {
        if (!available && !hasNext()) throw new NoSuchElementException();
        available = false;
        return next;
    }
}