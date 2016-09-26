/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.attribute.Attribute;
import org.lexia.core.format.AttributeFormat;
import org.lexia.core.format.Label;
import org.lexia.core.format.MemberFormat;
import org.lexia.core.value.Value;

/**
 *
 * @author genesis
 */
public class ValueLEX69 extends Value {

    protected ValueLEX69(Attribute attribute, String value, Boolean not) {
        super(attribute, value, not);
    }

    public static final Value THE_NAME(String value) {
        return THE_THING(AttributeLEX69.NAMEs(), value);
    }

    public static final Value NOT_NAME(String value) {
        return NOT_THE_THING(AttributeLEX69.NAMEs(), value);
    }

    public static final Value ANY_NAME(String expression) {
        return ANY_THING(AttributeLEX69.NAMEs(), expression);
    }

    public static final Value TEXT(String value) {
        return new ValueLEX69(AttributeLEX69.TEXTs(), value, false);
    }

    ;
    public static final Value TIMESTAMP(String value) {
        return new ValueLEX69(AttributeLEX69.TIMESTAMPs(), value, false);
    }

    public static final Value A_THING(Attribute attribute) {
        return new ValueLEX69(attribute, null, null);
    }
    public static final Value ANY_THING(Attribute attribute, String expression) {
        if (expression != null) {
            return new ValueLEX69(attribute, expression, null);
        } else {
            return A_THING(attribute);
        }
    }

    public static final Value ALL_THING(Attribute attribute) {//value not known
        return new ValueLEX69(attribute, null, false);
    }
    public static final Value THE_THING(Attribute attribute, String value) {//value known
        if (value != null) {
            return new ValueLEX69(attribute, value, false);
        } else {
            return ALL_THING(attribute);
        }
    }

    public static final Value NO_THING(Attribute attribute) {
        return new ValueLEX69(attribute, null, true);
    }
    public static final Value NOT_THE_THING(Attribute attribute, String value) {
        if (value != null) {
            return new ValueLEX69(attribute, value, true);
        } else {
            return NO_THING(attribute);
        }
    }

    public static void main(String[] args) {
        test(KindFormat.LEXIA);
        test(KindFormat.JSON);
        test(KindFormat.URL_PATH);
        //test(KindFormat.URL_QUERY);
    }

    private static void testDefault(MemberFormat format) {
        System.out.println("OPEN:" + format.open + ", IS:" + format.is + ", CLOSE:" + format.close + ",:");
        System.out.println();
        System.out.println(ValueLEX69.THE_NAME("value").toURI(format));
        System.out.println(Value.ToValue(format, ValueLEX69.THE_NAME("value").toURI(format)).toURI(format));
        System.out.println(ValueLEX69.THE_NAME("value").attribute.toURI(format));
        System.out.println();
    }

    private static void test(MemberFormat format) {
        //testDefault(format);

        //System.out.println(Value.ToURI(fluffy, AttributeListFormat.URL_QUERY));
        //System.out.println("NOT: " + ValueLEX69.NOT_NAME("value").toURI(format));
        //System.out.println("NOT: " + Value.ToValue(format, ValueLEX69.NOT_NAME("value").toURI(format)).toURI(format));
        //System.out.println("NOT: " + ValueLEX69.NOT_NAME("value").attribute.toURI(format));
        System.out.println();
        System.out.println("ALL: " + ValueLEX69.THE_NAME(null).toURI(format));
        System.out.println("ALL: " + Value.ToValue(format, ValueLEX69.THE_NAME(null).toURI(format)).toURI(format));
        System.out.println("ALL: " + ValueLEX69.THE_NAME(null).attribute.toURI(format));
        System.out.println();
        //System.out.println("NO: " + ValueLEX69.NOT_NAME(null).toURI(format));
        //System.out.println("NO: " + Value.ToValue(format, ValueLEX69.NOT_NAME(null).toURI(format)).toURI(format));
        //System.out.println("NO: " + ValueLEX69.NOT_NAME(null).attribute.toURI(format));
        System.out.println();
        //System.out.println("ANY: " + ValueLEX69.ANY_NAME(".*").toURI(format));
        //System.out.println("ANY: " + Value.ToValue(format, ValueLEX69.ANY_NAME(".*").toURI(format)).toURI(format));
        //System.out.println("ANY: " + ValueLEX69.ANY_NAME(".*").attribute.toURI(format));
        System.out.println();
    }

    public static final String ToURI(Value value,MemberFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(value,builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(Value value,StringBuilder builder, MemberFormat format) {
        //format.appendLabel(builder, VALUE);
        //builder.append(format.is);
        //builder.append(format.open);
        //value.scopeName().appendToURI(builder, format.attributeFormat);
        //builder.append(format.and);
        AppendStateToURI(builder, format.attributeFormat, Attribute.NAME, value.attribute.name);
        builder.append(":");//format.and
        if (value.value != null) {
            AppendStateToURI(builder, format.attributeFormat, VALUE, value.value.toString());
        } else {
            AppendStateToURI(builder, format.attributeFormat, VALUE, null);
        }
        //if (format.open.length() > 0) {
        //builder.append(format.close);
        //}
    }
    
    public static final void AppendStateToURI(StringBuilder builder, AttributeFormat format, Label label, String value) {
        //format.appendLabel(builder, label);
        //builder.append(format.is);
        format.appendValue(builder, value);
    }
}
