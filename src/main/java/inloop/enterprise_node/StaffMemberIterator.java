package inloop.enterprise_node;

import java.util.Set;

public class StaffMemberIterator<EnterpriseNode> implements EnterpriseNodeIterator<EnterpriseNode> {
    private Set<StaffMember> allMembers;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        this.allMembers = directSubordinates;
    }

    private void findSubordinatesRecursively(StaffMember m){

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public EnterpriseNode next() {
        return null;
    }
}
