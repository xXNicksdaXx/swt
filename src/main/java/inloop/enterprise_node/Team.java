package inloop.enterprise_node;

import java.util.SortedSet;

public class Team extends AbstractEnterpriseUnit{
    private StaffMember teamLeader;

    public Team(String name, StaffMember teamLeader) {
        super(name);
        if(teamLeader == null) throw new NullPointerException("teamLeader cannot be null!");
        this.teamLeader = teamLeader;
    }

    public StaffMember getTeamLeader() {
        return teamLeader;
    }

    public SortedSet<StaffMember> getTeamMembers(){
        return teamLeader.getDirectSubordinates();
    }
}
