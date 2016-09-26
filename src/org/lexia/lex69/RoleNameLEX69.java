/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.AttributeFormat;
import org.lexia.core.role.RoleName;

/**
 *
 * @author genesis
 */
public class RoleNameLEX69 {
    public static final void AppendToURI(RoleName roleName,StringBuilder builder, AttributeFormat format) {
        //format.appendLabel(builder, ROLE);
        //builder.append(format.is);
        format.appendValue(builder,roleName.name);
    }
}
