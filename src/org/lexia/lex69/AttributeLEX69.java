/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.lexia.core.OhNo;
import org.lexia.core.Oops;
import org.lexia.core.attribute.Attribute;
import static org.lexia.core.attribute.Attribute.ToAttribute;
import org.lexia.core.format.AttributeFormat;
import org.lexia.core.format.MemberFormat;
import org.lexia.core.format.MemberListFormat;

/**
 *
 * @author genesis
 */
public class AttributeLEX69 extends Attribute {

    private AttributeLEX69(String name) {
        super(name);
    }

    public static final Attribute NAMEs() {
        return Attribute.instance("name");
    }

    ;
    public static final Attribute TEXTs() {
        return Attribute.instance("text");
    }

    ;
    public static final Attribute TIMESTAMPs() {
        return Attribute.instance("timestamp");
    }

    public static void main(String[] args) {
        testEqual(NAMEs(),NAMEs());

        
        test(NAMEs(), KindFormat.LEXIA);
        test(NAMEs(), KindFormat.JSON);
        test(NAMEs(), KindFormat.URL_PATH);
        //test(NAMEs(), KindFormat.URL_QUERY);
    
        Set<Attribute> attributes = new HashSet<Attribute>();
        attributes.add(NAMEs());
        attributes.add(TEXTs());
        attributes.add(TIMESTAMPs());
        //test(attributes, AttributeLEX69.LEXIA_AL);
        //test(attributes, AttributeLEX69.JSON_AL);
        //test(attributes, AttributeLEX69.URL_PATH_AL);
    }

    public static void test(Attribute attribute, MemberFormat format) {
        String uri = attribute.toURI(format);
        System.out.println(uri);
        attribute = ToAttribute(format, uri);
        uri = attribute.toURI(format);
        System.out.println(uri);
    }

    public static void test(Set<Attribute> attributes, MemberListFormat format) {
        //String uri = format.toURI(attributes);
        //System.out.println(uri);
        //attribute = ToAttribute(format, uri);
        //uri = attribute.toURI(format);
        //System.out.println(uri);
    }

    public static final AttributeFormat CSV = new AttributeFormat("",new AttributeFormat.Quote("\"","\""));
    public static final AttributeFormat LEXIA = new AttributeFormat("=",new AttributeFormat.Quote("\"","\""));
    public static final AttributeFormat JSON = new AttributeFormat(":",new AttributeFormat.Quote("\"","\""));
    public static final AttributeFormat URL_PATH = new AttributeFormat("/",new AttributeFormat.Quote("",""));
    public static final AttributeFormat URL_QUERY = new AttributeFormat("=",new AttributeFormat.Quote("",""));

    //public static final MemberListFormat LEXIA_AL = new MemberListFormat("[", ":",",","]",KindFormat.LEXIA);
    //public static final MemberListFormat JSON_AL = new MemberListFormat("[", ":", ",", "]",KindFormat.JSON);
    //public static final MemberListFormat URL_PATH_AL = new MemberListFormat("","/", "/", "/",KindFormat.URL_PATH);
    //public static final MemberListFormat URL_QUERY_AL = new MemberListFormat("?","",new BasicFormat.Quote("", ""), "&", "",URL_QUERY);

    
    private static void testEqual(Attribute a,Attribute b) {
        if (!Objects.equals(a, b)) {
            if (!Objects.equals(a.name, b.name)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.name.toString());
            }
            throw new Oops(OhNo.MULTIPLE_FOUND,a.toString());
        }
    }
}
