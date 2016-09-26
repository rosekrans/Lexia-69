/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.MemberListFormat;
import org.lexia.core.legend.Legend;
import org.lexia.core.symbol.Symbol;
import org.lexia.core.value.Value;

/**
 *
 * @author genesis
 */
public class SymbolLEX69 extends Symbol {
    public SymbolLEX69(Legend legend, Value identityValue) {
        super(legend, identityValue);
    }
    public static final String ToURI(Symbol symbol,MemberListFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(symbol,builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(Symbol symbol,StringBuilder builder, MemberListFormat listFormat) {
        if (symbol.identityValue != null) {
            ValueLEX69.AppendToURI(symbol.identityValue,builder, listFormat.memberFormat);
        }
    }

    private static final Symbol NAME(Value value) {
        return new SymbolLEX69(LegendLEX69.NAMEs(), value);
    }
    private static final Symbol CONTEXT(Value value) {
        return new SymbolLEX69(LegendLEX69.CONTEXTs(), value);
    }
    private static final Symbol METHOD(Value value) {
        return new SymbolLEX69(LegendLEX69.METHODs(), value);
    }
    public static final Symbol USER(Value value) {
        return new SymbolLEX69(LegendLEX69.USERs(), value);
    }
    public static final Symbol THE_NAME(String value) {
        return new SymbolLEX69(LegendLEX69.NAMEs(), ValueLEX69.THE_NAME(value));
    }
    public static final Symbol THE_CONTEXT(String value) {
        return new SymbolLEX69(LegendLEX69.CONTEXTs(), ValueLEX69.THE_NAME(value));
    }
    public static final Symbol THE_METHOD(String value) {
        return new SymbolLEX69(LegendLEX69.METHODs(), ValueLEX69.THE_NAME(value));
    }
    public static final Symbol NOT_NAME(String value) {
        return new SymbolLEX69(LegendLEX69.NAMEs(), ValueLEX69.NOT_NAME(value));
    }
    public static final Symbol NOT_CONTEXT(String value) {
        return new SymbolLEX69(LegendLEX69.CONTEXTs(), ValueLEX69.NOT_NAME(value));
    }

    public static final Symbol TIME(Value value) {
        return new SymbolLEX69(LegendLEX69.TIMEs(), value);
    }

    /*public static final Value ANYTHING(Attribute attribute) {
        return new SymbolLEX69(attribute, null, ScopeName.ANY);
    }

    public static final Value NOTHING(Attribute attribute) {
        return new SymbolLEX69(attribute, null, ScopeName.NO);
    }*/

    public static void main(String[] args) {
        test(KindListFormat.LEXIA);
        test(KindListFormat.JSON);
        test(KindListFormat.URL_PATH);
        //test(KindListFormat.URL_QUERY);
    }
    private static void testDefault(MemberListFormat format) {
        System.out.println("<>OPEN<"+format.open+">IS<"+format.is+">CLOSE<"+format.close+">");
        System.out.println(SymbolLEX69.NAME(ValueLEX69.THE_NAME("value")).toURI(format));
        //System.out.println(Symbol.ToValue(format, SymbolLEX69.THE_NAME(ValueLEX69.THE_NAME("value")).toURI(format)).toURI(format));
        //System.out.println(SymbolLEX69.THE_NAME("value").attribute.toURI(format));
    }
    
    private static void test(MemberListFormat format) {
        testDefault(format);
        
        //System.out.println(Value.ToURI(fluffy, AttributeListFormat.URL_QUERY));
        System.out.println("NOT: " + SymbolLEX69.NAME(ValueLEX69.NOT_NAME("value")).toURI(format));
        //System.out.println("NOT: " + Symbol.ToValue(format, SymbolLEX69.THE_NAME(ValueLEX69.NOT_NAME("value")).toURI(format)).toURI(format));
        //System.out.println("NOT: " + SymbolLEX69.NOT_NAME("value").attribute.toURI(format));

        System.out.println("ANY: " + SymbolLEX69.NAME(ValueLEX69.THE_NAME(null)).toURI(format));
        //System.out.println("ANY: " + Value.ToValue(format, SymbolLEX69.THE_NAME(null).toURI(format)).toURI(format));
        //System.out.println("ANY: " + SymbolLEX69.THE_NAME(null).attribute.toURI(format));

        System.out.println("NO: " + SymbolLEX69.NAME(ValueLEX69.NOT_NAME(null)).toURI(format));
        //System.out.println("NO: " + Value.ToValue(format, SymbolLEX69.NOT_NAME(null).toURI(format)).toURI(format));
        //System.out.println("NO: " + SymbolLEX69.NOT_NAME(null).attribute.toURI(format));
       
        System.out.println("ANY: " + SymbolLEX69.NAME(ValueLEX69.ANY_NAME(null)).toURI(format));
        //System.out.println("ANY: " + Value.ToValue(format, SymbolLEX69.ANY_NAME(null).toURI(format)).toURI(format));
        //System.out.println("ANY: " + SymbolLEX69.ANY_NAME(null).attribute.toURI(format));
}

}
