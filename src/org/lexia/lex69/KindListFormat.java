/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import org.lexia.core.format.MemberListFormat;


/**
 *
 * @author genesis
 * /name/value --> "/","/",""
 * name=value  --> "","=",""
 */
public class KindListFormat extends MemberListFormat {
    


    private KindListFormat(String open,String is, String and, String close,KindFormat subjectFormat) {
        super(open,is, and, close, subjectFormat);
    }

    public static final KindListFormat CSV = new KindListFormat("","", ",", "",KindFormat.CSV);
    public static final KindListFormat LEXIA = new KindListFormat("[","=", ",", "]",KindFormat.LEXIA);
    public static final KindListFormat JSON = new KindListFormat("[",":", ",", "]",KindFormat.JSON);
    public static final KindListFormat URL_PATH = new KindListFormat("", "/","/", "",KindFormat.URL_PATH);
}
