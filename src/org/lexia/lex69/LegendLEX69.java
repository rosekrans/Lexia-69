/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.Objects;
import org.lexia.core.OhNo;
import org.lexia.core.Oops;
import org.lexia.core.attribute.Attribute;
import org.lexia.core.legend.Legend;
import org.lexia.core.legend.LegendName;

/**
 *
 * @author genesis
 */
public class LegendLEX69 extends Legend {

    private LegendLEX69(LegendName name, Attribute identityAttribute) {
        super(name, identityAttribute);
    }

    public static final Legend NAMEs() {
        return Legend.instance(LegendNameLEX69.NAME(), AttributeLEX69.NAMEs());
    }

    public static final Legend CONTEXTs() {
        return Legend.instance(LegendNameLEX69.CONTEXT(), AttributeLEX69.NAMEs());
    }
    public static final Legend METHODs() {
        return Legend.instance(LegendNameLEX69.METHOD(), AttributeLEX69.NAMEs());
    }

    public static final Legend USERs() {
        return Legend.instance(LegendNameLEX69.USER(), AttributeLEX69.NAMEs());
    }
    
    public static final Legend TIMEs() {
        return Legend.instance(LegendNameLEX69.TIME(), AttributeLEX69.TIMESTAMPs());
    }

    public static void main(String[] args) {
        testEqual(NAMEs(),NAMEs());
    }

    
    private static void testEqual(Legend a,Legend b) {
        if (!Objects.equals(a, b)) {
            if (!Objects.equals(a.legendName, b.legendName)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.legendName.toString());
            }
            if (!Objects.equals(a.identityAttribute, b.identityAttribute)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.identityAttribute.toString());
            }
            throw new Oops(OhNo.MULTIPLE_FOUND,a.toString());
        }
    }
}
