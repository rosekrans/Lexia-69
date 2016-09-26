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
import org.lexia.core.format.MemberListFormat;
import org.lexia.core.kind.DomainSet;
import org.lexia.core.kind.Kind;
import org.lexia.core.kind.KindName;
import org.lexia.core.kind.Shape;
import org.lexia.core.legend.Legend;
import org.lexia.core.role.KindRole;

/**
 *
 * @author genesis
 */
public class KindLEX69 extends Kind {

    public KindLEX69(DomainSet domainType, KindName name, Legend identityLegend, Shape shape, Set<Attribute> aspectAttributes) {
        super(domainType, name, identityLegend, shape, aspectAttributes);
    }

    //named
    /*public static final Kind KIND() {
        return Kind.named(DomainSet.SYSTEM_SET, KindNameLEX69.KIND(), LegendLEX69.NAMEs());
    }*/

    public static final Kind USER() {
        return Kind.named(DomainSet.SYSTEM_SET, KindNameLEX69.USER(), LegendLEX69.USERs());
    }

    public static final Kind TIME() {
        return Kind.named(DomainSet.SYSTEM_SET, KindNameLEX69.TIME(), LegendLEX69.TIMEs());
    }

    public static final Kind NAME(DomainSet domainSet) {
        return Kind.named(domainSet, KindNameLEX69.NAME(), LegendLEX69.NAMEs());
    }

    public static final Kind CONTEXT(DomainSet domainSet) {
        return Kind.named(domainSet, KindNameLEX69.CONTEXT(), LegendLEX69.CONTEXTs());
    }

    public static final Kind METHOD(DomainSet domainSet) {
        return Kind.named(domainSet, KindNameLEX69.METHOD(), LegendLEX69.METHODs());
    }

    //shaped
    public static final Kind TYPE(DomainSet domainType) {
        KindRole nameRole = KindRole.AS(KindLEX69.NAME(domainType));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(nameRole);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_COMPLIMENT_SET, new HashSet<Attribute>(), KindNameLEX69.TYPE(), shape);
    }

    public static final Kind FLAG_TYPE(DomainSet domainType) {
        KindRole nameRole = KindRole.AS(KindLEX69.NAME(domainType));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(nameRole);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_COMPLIMENT_SET, new HashSet<Attribute>(), KindNameLEX69.FLAG_TYPE(), shape);
    }

    public static final Kind FLAG_OPTION(DomainSet domainType) {
        KindRole nameRole = KindRole.AS(KindLEX69.NAME(domainType));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(nameRole);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_COMPLIMENT_SET, new HashSet<Attribute>(), KindNameLEX69.FLAG_OPTION(), shape);
    }

    public static final Kind NODE(DomainSet domainType) {
        KindRole type = KindRole.AS(KindLEX69.TYPE(domainType));
        KindRole name = KindRole.AS(KindLEX69.NAME(domainType));
        Set kindRoles = new HashSet<>();
        kindRoles.add(type);
        kindRoles.add(name);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(domainType, new HashSet<Attribute>(), KindNameLEX69.NODE(), shape);
    }

    public static final Kind LINK(DomainSet fromDomain,DomainSet toDomain) {
        DomainSet domainSet = DomainSet.SYSTEM_COMPLIMENT_SET;
        if ((fromDomain.equals(DomainSet.SYSTEM_SET))||(toDomain.equals(DomainSet.SYSTEM_SET))) {
            domainSet = DomainSet.SYSTEM_SET;
        }
        KindRole fromNode = KindRole.FROM(KindLEX69.NODE(fromDomain));
        KindRole toNode = KindRole.TO(KindLEX69.NODE(toDomain));
        KindRole name = KindRole.AS(KindLEX69.NAME(domainSet));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(fromNode);
        kindRoles.add(toNode);
        kindRoles.add(name);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(domainSet, new HashSet<Attribute>(), KindNameLEX69.LINK(), shape);
    }
    
    public static final Kind ROLE(DomainSet fromDomain) {
        DomainSet domainSet = DomainSet.SYSTEM_SET;
        KindRole node = KindRole.AS(KindLEX69.NODE(fromDomain));
        KindRole context = KindRole.AS(KindLEX69.CONTEXT(domainSet));
        KindRole method = KindRole.AS(KindLEX69.METHOD(domainSet));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(node);
        kindRoles.add(context);
        kindRoles.add(method);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(domainSet, new HashSet<Attribute>(), KindNameLEX69.NODE_ROLE(), shape);
    }

    public static final Kind LINK_FLAG(DomainSet fromDomain,DomainSet toDomain) {
        KindRole flagType = KindRole.AS(KindLEX69.FLAG_TYPE(toDomain));
        KindRole flagOption = KindRole.AS(KindLEX69.FLAG_OPTION(toDomain));
        KindRole user = KindRole.AS(KindLEX69.USER());
        KindRole context = KindRole.AS(KindLEX69.CONTEXT(toDomain));
        KindRole link = KindRole.AS(KindLEX69.LINK(fromDomain,toDomain));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(flagType);
        kindRoles.add(flagOption);
        kindRoles.add(user);
        kindRoles.add(context);
        kindRoles.add(link);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.LINK_FLAG(), shape);
    }

    public static final Kind LINK_TOUCH(DomainSet fromDomain,DomainSet toDomain) {
        KindRole request = KindRole.AS(KindLEX69.REQUEST());
        KindRole link = KindRole.AS(KindLEX69.LINK(fromDomain,toDomain));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(request);
        kindRoles.add(link);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.LINK_TOUCH(), shape);
    }

    public static final Kind LINK_IMAGE(DomainSet fromDomain,DomainSet toDomain) {
        KindRole touch = KindRole.AS(KindLEX69.LINK_TOUCH(fromDomain,toDomain));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(touch);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.LINK_IMAGE(), shape);
    }
    
    //aggregates
    public static final Kind REQUEST() {
        KindRole user = KindRole.AS(KindLEX69.USER());
        KindRole time = KindRole.AS(KindLEX69.TIME());
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(user);
        kindRoles.add(time);
        Shape shape = new Shape(kindRoles);
        return Kind.namedAndShaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.REQUEST(),shape, LegendLEX69.NAMEs());
    }

 
    public static final Kind TEXT() {
        KindRole toType = KindRole.TO(KindLEX69.TYPE(DomainSet.SYSTEM_COMPLIMENT_SET));
        KindRole toName = KindRole.TO(KindLEX69.NAME(DomainSet.SYSTEM_COMPLIMENT_SET));
        KindRole name = KindRole.AS(KindLEX69.NAME(DomainSet.SYSTEM_COMPLIMENT_SET));
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(toType);
        kindRoles.add(toName);
        kindRoles.add(name);
        Shape shape = new Shape(kindRoles);
        Set<Attribute> attributes = new HashSet<>();
        attributes.add(AttributeLEX69.TEXTs());
        return Kind.shaped(DomainSet.SYSTEM_COMPLIMENT_SET, attributes, KindNameLEX69.TEXT(), shape);
    }

    /*public static final Kind TYPE_TOUCH(DomainSet typeDomain) {
        KindRole type = KindRole.AS(KindLEX69.TYPE(typeDomain));
        KindRole request = KindRole.AS(KindLEX69.REQUEST());
        Kind handle = HANDLE();
        KindRole previous = KindRole.PREVIOUS(handle);
        Set<KindRole> kindRoles = new HashSet<>();
        kindRoles.add(type);
        kindRoles.add(request);
        kindRoles.add(previous);
        Shape shape = new Shape(kindRoles);
        return Kind.shaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.TYPE_TOUCH(), shape);
    }*/

    /*public static final Kind TYPE_IMAGE(DomainSet typeDomain) {
        KindRole name = KindRole.AS(KindLEX69.NAME(DomainSet.SYSTEM_SET));
        KindRole typeTouch = KindRole.AS(TYPE_TOUCH(typeDomain));
        Kind handle = HANDLE();
        KindRole previous = KindRole.PREVIOUS(handle);
        Set kindRoles = new HashSet<KindRole>();
        kindRoles.add(name);
        kindRoles.add(typeTouch);
        kindRoles.add(previous);
        Shape shape = new Shape(kindRoles);
        Set<Kind> handles = new HashSet<>();
        handles.add(handle);
        return Kind.shaped(DomainSet.SYSTEM_SET, new HashSet<Attribute>(), KindNameLEX69.TYPE_IMAGE(), shape);
    }*/

    public static final Kind TEST(DomainSet domainType) {
        Shape shape = new Shape();
        return KindLEX69.instance(domainType, new HashSet<Attribute>(), KindNameLEX69.TEST(), shape, LegendLEX69.NAMEs());

    }

    public static void main(String[] args) {
        testEqual(NAME(DomainSet.SYSTEM_COMPLIMENT_SET),NAME(DomainSet.SYSTEM_COMPLIMENT_SET));
        //testEqual(TYPE(DomainSet.SYSTEM_COMPLIMENT_SET),TYPE(DomainSet.SYSTEM_COMPLIMENT_SET));
        //testFormat(KindListFormat.LEXIA);
        //testFormat(KindListFormat.JSON);
        //testFormat(KindListFormat.URL_PATH);
    }

    
    private static void testEqual(Kind a,Kind b) {
        if (!Objects.equals(a, b)) {
            if (!Objects.equals(a.domainSet, b.domainSet)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.domainSet.name);
            }
            if (!Objects.equals(a.aspectAttributes, b.aspectAttributes)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.aspectAttributes.toString());
            }
            if (!Objects.equals(a.identityLegend, b.identityLegend)) {
                throw new Oops(OhNo.MULTIPLE_FOUND,a.identityLegend.toString());
            }
            if (!Objects.equals(a.shape, b.shape)) {
                if (!Objects.equals(a.shape.kindRoles, b.shape.kindRoles)) {
                    throw new Oops(OhNo.MULTIPLE_FOUND,a.shape.kindRoles.toString());
                }
                throw new Oops(OhNo.MULTIPLE_FOUND,a.shape.toString());
            }
            throw new Oops(OhNo.MULTIPLE_FOUND,a);
        }
    }

    private static void testFormat(MemberListFormat format) {
        Kind kind;
        System.out.println("<>OPEN<" + format.open + ">IS<" + format.is + ">AND<" + format.and + ">CLOSE<" + format.close + ">");

        kind = TEST(DomainSet.SYSTEM_SET);
        System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format)), format, context).toURI(format, context));
        System.out.println();

        //kind = KIND();
        //System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        //System.out.println();

        kind = NAME(DomainSet.SYSTEM_COMPLIMENT_SET);
        System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        System.out.println();
        kind = TYPE(DomainSet.SYSTEM_COMPLIMENT_SET);
        System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        System.out.println();
        kind = NODE(DomainSet.SYSTEM_COMPLIMENT_SET);
        System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        System.out.println();
        //kind = HANDLE();
        //System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        //System.out.println();
        kind = REQUEST();
        //System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        System.out.println();
        //kind = TYPE_TOUCH(DomainSet.SYSTEM_COMPLIMENT_SET);
        //System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        //System.out.println();
        //kind = TYPE_IMAGE(DomainSet.SYSTEM_COMPLIMENT_SET);
        //System.out.println(kind.toURI(format));
        //System.out.println(Kind.StripKind(new StringBuilder(kind.toURI(format, context)), format, context).toURI(format, context));
        //System.out.println();
    }

    
}
