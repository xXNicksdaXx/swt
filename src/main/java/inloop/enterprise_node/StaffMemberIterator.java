package inloop.enterprise_node;

import java.util.*;

public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember> {
    private SortedSet<StaffMember> allMembers;
    private boolean available = false;
    private StaffMember next;
    private Deque<StaffMember> queue;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        if(directSubordinates == null) throw new NullPointerException("directSubordinates cannot be null!");
    }

    private void findSubordinatesRecursively(StaffMember m){
        if (m == null) throw new NullPointerException("m cannot be null!");

        Set<StaffMember> subordinates = m.getDirectSubordinates();
        if (subordinates.isEmpty()) return;
        else{
            for(StaffMember sub : subordinates){
                sub.getDirectSubordinates();
            }
        }
    }

    @Override
    public boolean hasNext() {
        while (!queue.isEmpty()) {
            StaffMember member = queue.getFirst();
            queue.pop();

            next = member;
            available = true;

            return true;
        }

        available = false;
        return false;
    }

    @Override
    public StaffMember next() {
        if (!available && !hasNext()) throw new NoSuchElementException();
        available = false;
        return next;
    }
}