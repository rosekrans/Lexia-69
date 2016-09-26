/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.Set;
import org.lexia.core.format.MemberListFormat;
import org.lexia.core.goal.Variation;
import static org.lexia.core.goal.Variation.VARIATION;
import org.lexia.core.kind.Shape;
import org.lexia.core.role.GoalRole;

/**
 *
 * @author genesis
 */
public class VariationLEX69 extends Variation {

    public VariationLEX69(Shape shape, Set<GoalRole> goalRoles) {
        super(shape, goalRoles);
    }
    
    public static final String ToURI(Variation variation,MemberListFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(variation,builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(Variation variation,StringBuilder builder, MemberListFormat format) {
        //format.appendLabel(builder, VARIATION);
        //builder.append(format.is);
        if (variation.goalRoles.size() > 0) {
            //builder.append(format.open);
            String and = "";
            for (GoalRole goalRole : variation.goalRoles.values()) {
                builder.append(and);
                GoalRoleLEX69.AppendToURI(goalRole,builder, format);
                and = format.and;
            }
            //builder.append(format.close);
        } else {
                //builder.append(format.open);
                //builder.append(format.close);
        }
    }
}
