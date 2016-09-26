/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.Objects;
import org.lexia.core.OhNo;
import org.lexia.core.Oops;
import org.lexia.core.format.Label;
import org.lexia.core.format.MemberFormat;
import org.lexia.core.kind.KindName;

/**
 *
 * @author genesis
 */
public class KindNameLEX69 extends KindName {

    private KindNameLEX69(String name,String abbreviation) {
        super(name,abbreviation);
    }

    //public static final KindName KIND(){return KindName.instance("KIND");};
    //public static final KindName HANDLE(){return KindName.instance("HAMDLE");};
    public static final KindName NAME(){return KindName.instance("name","i");};
    public static final KindName TYPE(){return KindName.instance("type","t");};
    public static final KindName FLAG_TYPE(){return KindName.instance("flag_type","ft");};
    public static final KindName FLAG_OPTION(){return KindName.instance("flag_option","fo");};
    public static final KindName NODE(){return KindName.instance("node","n");};
    public static final KindName LINK(){return KindName.instance("link","l");};
    public static final KindName NODE_ROLE(){return KindName.instance("node_role","nr");};
    public static final KindName LINK_ROLE(){return KindName.instance("link_role","lr");};
    public static final KindName LINK_FLAG(){return KindName.instance("link_flag","lf");};
    public static final KindName TEXT(){return KindName.instance("text","c");};
    public static final KindName CONTEXT(){return KindName.instance("context","ct");};
    public static final KindName METHOD(){return KindName.instance("method","mh");};
    //
    public static final KindName USER(){return KindName.instance("user","u");};
    public static final KindName TIME(){return KindName.instance("time","p");};
    //public static final KindName NUMBER(){return KindName.instance("NUMBER");};
    //
    public static final KindName REQUEST(){return KindName.instance("request","r");};
    //public static final KindName TYPE_TOUCH(){return KindName.instance("TYPE_TOUCH");};
    //public static final KindName TYPE_IMAGE(){return KindName.instance("TYPE_IMAGE");};
    //public static final KindName NODE_TOUCH(){return KindName.instance("NODE_TOUCH");};
    //public static final KindName NODE_IMAGE(){return KindName.instance("NODE_IMAGE");};
    public static final KindName LINK_TOUCH(){return KindName.instance("link_touch","lt");};
    public static final KindName LINK_IMAGE(){return KindName.instance("link_image","li");};
    public static final KindName NODE_ROLE_TOUCH(){return KindName.instance("node_role_touch","nrt");};
    public static final KindName NODE_ROLE_IMAGE(){return KindName.instance("node_role_image","ri");};

    static final KindName TEST(){return KindName.instance("TEST","tst");};
    
    public static void main(String[] args) {
        testEqual();
    }

    private static void testEqual() {
        KindName a = TYPE();
        KindName b = TYPE();
        if (!Objects.equals(a, b)) {
            throw new Oops(OhNo.MULTIPLE_FOUND,a.name);
        }
    }
    public static final String ToURI(KindName kindName,MemberFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(kindName,builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(KindName kindName, StringBuilder builder, MemberFormat format) {
        //format.appendLabel(builder, KIND_NAME);
        format.appendLabel(builder, new Label("type"));
        builder.append(format.attributeFormat.is);
        format.appendValue(builder, kindName.name);
    }
}
