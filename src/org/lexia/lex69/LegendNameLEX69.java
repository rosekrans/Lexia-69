/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.MemberFormat;
import org.lexia.core.legend.LegendName;

/**
 *
 * @author genesis
 */
public class LegendNameLEX69 extends LegendName{

    private LegendNameLEX69(String name) {
        super(name);
    }
    
    public static final LegendName NAME() {
        return LegendName.instance("name");
    }
    
    public static final LegendName CONTEXT() {
        return LegendName.instance("context");
    }

    public static final LegendName METHOD() {
        return LegendName.instance("method");
    }

    public static final LegendName USER() {
        return LegendName.instance("user");
    }
    
    public static final LegendName TIME() {
        return LegendName.instance("time");
    }
    
        public static final String ToURI(LegendName legendName, MemberFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(legendName,builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(LegendName legendName,StringBuilder builder, MemberFormat format) {
        //format.appendLabel(builder, LEGEND_NAME);
        //builder.append(format.attributeFormat.is);
        format.appendValue(builder,legendName.name);
    }

}
