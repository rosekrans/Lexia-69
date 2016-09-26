/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.AttributeFormat;
import org.lexia.core.format.MemberFormat;

/**
 *
 * @author genesis /name/value --> "/","/","" name=value --> "","=",""
 */
public class KindFormat extends MemberFormat {

    private KindFormat(String open, String is, String and, String close, AttributeFormat identityValueFormat) {
        super(open, is, and, close,identityValueFormat);
    }

    public static final KindFormat CSV = new KindFormat("", "", ",", "", AttributeLEX69.CSV);
    public static final KindFormat LEXIA = new KindFormat("{", ":", ",", "}", AttributeLEX69.LEXIA);
    public static final KindFormat JSON = new KindFormat("{", ":", ",", "}", AttributeLEX69.JSON);
    public static final KindFormat URL_PATH = new KindFormat("", "/", "/", "/", AttributeLEX69.URL_PATH);
    //public static final KindFormat URL_QUERY = new KindFormat("?", "", "&", "", AttributeLEX69.URL_QUERY);
}
