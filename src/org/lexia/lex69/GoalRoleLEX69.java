/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.MemberListFormat;
import org.lexia.core.goal.Goal;
import org.lexia.core.role.GoalRole;
import static org.lexia.core.role.GoalRole.GOAL_ROLE;
import org.lexia.core.role.RoleName;

/**
 *
 * @author genesis
 */
public class GoalRoleLEX69 extends GoalRole {

    public GoalRoleLEX69(RoleName roleName, Goal goal) {
        super(roleName, goal);
    }
    
    public static final String toURI(GoalRole goalRole, MemberListFormat listFormat) {
        StringBuilder builder = new StringBuilder();
        builder.append(GOAL_ROLE).append(listFormat.memberFormat.is);
        AppendToURI(goalRole,builder, listFormat);
        return builder.toString();
    }

    public static final void AppendToURI(GoalRole goalRole,StringBuilder builder, MemberListFormat listFormat) {
        builder.append("\"");//listFormat.memberFormat.open
        RoleNameLEX69.AppendToURI(goalRole.roleName,builder, listFormat.memberFormat.attributeFormat);
        builder.append(listFormat.memberFormat.and);
        GoalLEX69.AppendToURI(goalRole.goal,builder, listFormat);
        //builder.append(listFormat.memberFormat.close);
    }
}
