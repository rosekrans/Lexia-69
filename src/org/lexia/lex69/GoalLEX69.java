/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import org.lexia.core.format.MemberListFormat;
import org.lexia.core.goal.Goal;
import org.lexia.core.goal.ScopeGoal;
import org.lexia.core.goal.Variation;
import org.lexia.core.kind.DomainSet;
import org.lexia.core.kind.Kind;
import org.lexia.core.role.GoalRole;
import org.lexia.core.role.KindRole;
import org.lexia.core.role.RoleName;
import org.lexia.core.symbol.Symbol;
import org.lexia.core.value.Value;

/**
 *
 * @author genesis
 */
public class GoalLEX69 extends Goal {

    public GoalLEX69(Kind kind, Set<Value> aspectValues, Variation variation, Symbol identitySymbol) {
        super(kind, null, aspectValues, variation, identitySymbol);
    }

    public static final Goal NAME(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.NAME(domainSet), null, new HashSet<Value>(), SymbolLEX69.THE_NAME(name));
    }

    public static final Goal CONTEXT(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.CONTEXT(domainSet), null, new HashSet<Value>(), SymbolLEX69.THE_CONTEXT(name));
    }

    public static final Goal METHOD(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.METHOD(domainSet), null, new HashSet<Value>(), SymbolLEX69.THE_METHOD(name));
    }

    public static final Goal NOT_NAME(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.NAME(domainSet), null, new HashSet<Value>(), SymbolLEX69.NOT_NAME(name));
    }

    public static final Goal NOT_CONTEXT(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.CONTEXT(domainSet), null, new HashSet<Value>(), SymbolLEX69.NOT_NAME(name));
    }

    public static final Goal NOT_METHOD(DomainSet domainSet, String name) {
        return Goal.named(KindLEX69.METHOD(domainSet), null, new HashSet<Value>(), SymbolLEX69.NOT_NAME(name));
    }

    public static final Goal USER(String name) {
        Value userName = ValueLEX69.THE_NAME(name);
        return Goal.named(KindLEX69.USER(), null, new HashSet<Value>(), SymbolLEX69.USER(userName));
    }

    public static final Goal TIME(String time) {
        Value timeValue = ValueLEX69.TIMESTAMP(time);
        return Goal.named(KindLEX69.TIME(), null, new HashSet<Value>(), SymbolLEX69.TIME(timeValue));
    }

    public static final Goal TYPE(DomainSet domainType, Long id, String name) {
        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(domainType, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.TYPE(domainType).shape, goalRoles);
        return Goal.shaped(KindLEX69.TYPE(domainType), id, new HashSet<Value>(), variation);
    }

    public static final Goal FLAG_TYPE(DomainSet domainType, Long id, String name) {
        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(domainType, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.TYPE(domainType).shape, goalRoles);
        return Goal.shaped(KindLEX69.FLAG_TYPE(domainType), id, new HashSet<Value>(), variation);
    }

    public static final Goal FLAG_OPTION(DomainSet domainType, Long id, String name) {
        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(domainType, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.FLAG_OPTION(domainType).shape, goalRoles);
        return Goal.shaped(KindLEX69.FLAG_OPTION(domainType), id, new HashSet<Value>(), variation);
    }

    public static final Goal NODE(DomainSet domainType, Long typeId, String type, Long nodeId, String name) {
        GoalRole typeRole = GoalRole.AS(GoalLEX69.TYPE(domainType, typeId, type));
        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(domainType, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(typeRole);
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.NODE(domainType).shape, goalRoles);
        return Goal.shaped(KindLEX69.NODE(domainType), nodeId, new HashSet<Value>(), variation);
    }

    public static final Goal LINK(Long linkId, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        DomainSet domainSet = DomainSet.SYSTEM_COMPLIMENT_SET;
        if ((fromDomain.equals(DomainSet.SYSTEM_SET)) || (toDomain.equals(DomainSet.SYSTEM_SET))) {
            domainSet = DomainSet.SYSTEM_SET;
        }

        Set<GoalRole> goalRoles = new HashSet<>();
        GoalRole fromRole = GoalRole.FROM(GoalLEX69.NODE(fromDomain, null, fromType, null, fromName));
        goalRoles.add(fromRole);

        if ((toType != null) || (toName != null)) {
            GoalRole toRole = GoalRole.TO(GoalLEX69.NODE(toDomain, null, toType, null, toName));
            goalRoles.add(toRole);
        }

        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(domainSet, name));
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.LINK(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK(fromDomain, toDomain), linkId, new HashSet<Value>(), variation);
    }

    public static final Goal ROLE(Long roleId, DomainSet fromDomain, String nodeType, String nodeName, String contextName, String methodName) {
        DomainSet domainSet = DomainSet.SYSTEM_COMPLIMENT_SET;
        GoalRole nodeRole = GoalRole.AS(GoalLEX69.NODE(fromDomain, null, nodeType, null, nodeName));
        GoalRole contextRole = GoalRole.AS(GoalLEX69.CONTEXT(domainSet, contextName));
        GoalRole methodRole = GoalRole.AS(GoalLEX69.METHOD(domainSet, methodName));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(nodeRole);
        goalRoles.add(contextRole);
        goalRoles.add(methodRole);
        Variation variation = new Variation(KindLEX69.ROLE(fromDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.ROLE(fromDomain), roleId, new HashSet<Value>(), variation);
    }

    public static final Goal LINK_TOUCH(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        String any = null;
        Long tobe = null;
        GoalRole request = GoalRole.AS(GoalLEX69.REQUEST(tobe, any, any, requestSymbol));
        GoalRole link = GoalRole.AS(GoalLEX69.LINK(null, fromDomain, fromType, fromName, toDomain, toType, toName, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(request);
        goalRoles.add(link);
        Variation variation = new Variation(KindLEX69.LINK_TOUCH(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK_TOUCH(fromDomain, toDomain), null, new HashSet<Value>(), variation);
    }

    public static final Goal LINK_FLAG(String contextName, String userName, String flagTypeName, String flagOptionName, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        GoalRole flagType = GoalRole.AS(GoalLEX69.FLAG_TYPE(toDomain, null, flagTypeName));
        GoalRole flagOption = GoalRole.AS(GoalLEX69.FLAG_OPTION(toDomain, null, flagOptionName));
        GoalRole user = GoalRole.AS(GoalLEX69.USER(userName));
        GoalRole context = GoalRole.AS(GoalLEX69.CONTEXT(toDomain, contextName));
        GoalRole link = GoalRole.AS(GoalLEX69.LINK(null, fromDomain, fromType, fromName, toDomain, toType, toName, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(flagType);
        goalRoles.add(flagOption);
        goalRoles.add(user);
        goalRoles.add(context);
        goalRoles.add(link);
        Variation variation = new Variation(KindLEX69.LINK_FLAG(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK_FLAG(fromDomain, toDomain), null, new HashSet<Value>(), variation);
    }

    public static final Goal LINK_TOUCH(Goal requestGoal, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        String any = null;
        GoalRole request = GoalRole.AS(requestGoal);
        GoalRole link = GoalRole.AS(GoalLEX69.LINK(null, fromDomain, fromType, fromName, toDomain, toType, toName, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(request);
        goalRoles.add(link);
        Variation variation = new Variation(KindLEX69.LINK_TOUCH(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK_TOUCH(fromDomain, toDomain), null, new HashSet<Value>(), variation);
    }

    public static final Goal LINK_IMAGE(Goal requestGoal, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        GoalRole change = GoalRole.AS(GoalLEX69.LINK_TOUCH(requestGoal, fromDomain, fromType, fromName, toDomain, toType, toName, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(change);
        Variation variation = new Variation(KindLEX69.LINK_IMAGE(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK_IMAGE(fromDomain, toDomain), null, new HashSet<Value>(), variation);
    }

    public static final Goal LINK_IMAGE(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        GoalRole change = GoalRole.AS(GoalLEX69.LINK_TOUCH(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(change);
        Variation variation = new Variation(KindLEX69.LINK_IMAGE(fromDomain, toDomain).shape, goalRoles);
        return Goal.shaped(KindLEX69.LINK_IMAGE(fromDomain, toDomain), null, new HashSet<Value>(), variation);
    }

    public static final Goal REQUEST(Long id, String user, String time, String name) {
        System.out.println("String user:" + user);
        Goal userGoal = USER(user);
        Goal timeGoal = TIME(time);
        return REQUEST(id, userGoal, timeGoal, name);
    }

    public static final Goal REQUEST(Long id, Goal user, Goal time, String name) {
        System.out.println("Goal user:" + user.identitySymbol.identityValue.value);
        GoalRole userRole = GoalRole.AS(user);
        GoalRole timeRole = GoalRole.AS(time);
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(userRole);
        goalRoles.add(timeRole);
        Variation binding = new Variation(KindLEX69.REQUEST().shape, goalRoles);
        return Goal.namedAndShaped(KindLEX69.REQUEST(), id, new HashSet<Value>(), binding, SymbolLEX69.THE_NAME(name));
    }

    public static final Goal TEXT(String toType, String toName, String name, String text, Goal handle) {
        GoalRole toRole = GoalRole.TO(GoalLEX69.NODE(DomainSet.SYSTEM_COMPLIMENT_SET, null, toType, null, toName));
        GoalRole nameRole = GoalRole.AS(GoalLEX69.NAME(DomainSet.SYSTEM_COMPLIMENT_SET, name));
        Set<GoalRole> goalRoles = new HashSet<>();
        goalRoles.add(toRole);
        goalRoles.add(nameRole);
        Variation variation = new Variation(KindLEX69.TEXT().shape, goalRoles);
        Set<Goal> handles = new HashSet<>();
        Set<Value> values = new HashSet<>();
        values.add(ValueLEX69.TEXT(text));
        return Goal.namedAndShaped(KindLEX69.TEXT(), null, values, variation, handle.identitySymbol);
    }

    public static final Goal TEST(DomainSet domainType) {
        Variation variation = new Variation(KindLEX69.TEST(domainType).shape);
        return Goal.shapedAndHandledOrNamed(KindLEX69.TEST(domainType), null, new HashSet<Value>(), variation, null);

    }

    public static void main(String[] args) {
        test(KindListFormat.LEXIA);
        test(KindListFormat.JSON);
        test(KindListFormat.URL_PATH);
    }

    private static void test(MemberListFormat format) {
        Goal goal;
        System.out.println("<>OPEN<" + format.open + ">IS<" + format.is + ">AND<" + format.and + ">CLOSE<" + format.close + ">");

        goal = TEST(DomainSet.SYSTEM_COMPLIMENT_SET);
        System.out.println(goal.toURI(format));
        //System.out.println(Goal.ToGoal(new StringBuilder(goal.toURI(format)), format).toURI(format));
        System.out.println();

        goal = NAME(DomainSet.SYSTEM_COMPLIMENT_SET, "me");
        System.out.println(goal.toURI(format));
        //System.out.println(Goal.ToGoal(new StringBuilder(goal.toURI(format)), format).toURI(format));
        System.out.println();

        goal = TYPE(DomainSet.SYSTEM_COMPLIMENT_SET, null, "Server");
        System.out.println(goal.toURI(format));
        //System.out.println(Goal.ToGoal(new StringBuilder(goal.toURI(format)), format).toURI(format));
        System.out.println();

        goal = NODE(DomainSet.SYSTEM_COMPLIMENT_SET, null, "Server", null, "SRV000123");
        System.out.println(goal.toURI(format));
        //System.out.println(Goal.ToGoal(new StringBuilder(goal.toURI(format)), format).toURI(format));
        System.out.println();

    }

    public static final String ToURI(Goal goal, MemberListFormat format) {
        StringBuilder builder = new StringBuilder();
        AppendToURI(goal, builder, format);
        return builder.toString();
    }

    public static final void AppendToURI(Goal goal, StringBuilder builder, MemberListFormat listFormat) {
        KindNameLEX69.AppendToURI(goal.kind.kindName, builder, listFormat.memberFormat);
        builder.append(listFormat.memberFormat.and);
        Map<KindRole, GoalRole> variationMap = goal.variation.goalRoles;
        String and = "";
        for (Map.Entry<KindRole, GoalRole> entrySet : variationMap.entrySet()) {
            KindRole kindRole = entrySet.getKey();
            GoalRole goalRole = entrySet.getValue();
            Map<StringBuilder, String> map = new HashMap<StringBuilder, String>();
            expand(map, goalRole);
            for (Map.Entry<StringBuilder, String> mapEntry : map.entrySet()) {
                StringBuilder path = mapEntry.getKey();
                String symbol = mapEntry.getValue();
                builder.append(and);
                builder.append("\"");
                builder.append(goal.kind.kindName.name);
                builder.append(path);
                builder.append("\"");
                builder.append(":");
                builder.append("\"");
                builder.append(symbol);
                builder.append("\"");
                and = ",";
            }
        }
        if (goal.identitySymbol != null) {
            builder.append(and);
            SymbolLEX69.AppendToURI(goal.identitySymbol, builder, listFormat);
        }
        if (goal.id != null) {
            builder.append(and);
            builder.append("\"" + goal.kind.kindName.name + "/id\":\"");
            builder.append(goal.id.longValue());
            builder.append("\"");
            and = ",";
        }
        if (goal.getScopeGoals() != null) {
            List<ScopeGoal> scopeGoals = goal.getScopeGoals();
            for (ScopeGoal scopeGoal : scopeGoals) {
                Map<String, String> goalValues = scopeGoal.goalValues;
                for (Map.Entry<String, String> entrySet : goalValues.entrySet()) {
                    String key = entrySet.getKey();
                    String value = entrySet.getValue();
                    builder.append(and);
                    builder.append("\"");
                    builder.append(goal.kind.kindName.name);
                    builder.append("/");
                    builder.append(scopeGoal.scopeURI);
                    builder.append("/");
                    builder.append(key);
                    builder.append("\"");
                    builder.append(":");
                    builder.append("\"");
                    builder.append(value);
                    builder.append("\"");
                    and = ",";
                }
            }
        }
    }

    public static final void expand(Map<StringBuilder, String> parentMap, GoalRole goalRole) {
        StringBuilder path = new StringBuilder();
        if (RoleName.WITH.name.equals(goalRole.roleName.name)) {
            //path.append("/");
        } else {
            path.append("/");
            path.append(goalRole.roleName.name);
        }
        //path.append(goalRole.goal.kind.kindName.name);
        Map<StringBuilder, String> childmap = new HashMap<StringBuilder, String>();
        expand(childmap, goalRole.goal);
        for (Map.Entry<StringBuilder, String> entrySet : childmap.entrySet()) {
            StringBuilder key = entrySet.getKey();
            String value = entrySet.getValue();
            StringBuilder childPath = new StringBuilder(path.toString());
            //childPath.append("/");
            childPath.append(key.toString());
            parentMap.put(childPath, value);
        }
    }

    public static final void expand(Map<StringBuilder, String> parentMap, Goal goal) {
        StringBuilder path = new StringBuilder();
        path.append("/");
        path.append(goal.kind.kindName.name);

        Map<StringBuilder, String> childmap = new HashMap<StringBuilder, String>();
        expand(childmap, goal.identitySymbol);
        for (Map.Entry<StringBuilder, String> entrySet : childmap.entrySet()) {
            StringBuilder key = entrySet.getKey();
            String value = entrySet.getValue();
            StringBuilder childPath = new StringBuilder(path.toString());
            //childPath.append("/");
            //childPath.append(key.toString());
            parentMap.put(childPath, value);
        }

        childmap = new HashMap<StringBuilder, String>();
        expand(childmap, goal.variation);
        for (Map.Entry<StringBuilder, String> entrySet : childmap.entrySet()) {
            StringBuilder key = entrySet.getKey();
            String value = entrySet.getValue();
            StringBuilder childPath = new StringBuilder(path.toString());
            //childPath.append("/");
            childPath.append(key.toString());
            parentMap.put(childPath, value);
        }
    }

    public static final void expand(Map<StringBuilder, String> parentMap, Symbol symbol) {
        if (symbol != null) {
            StringBuilder path = new StringBuilder();
            //path.append(symbol.identityValue.attribute.name);
            String value = symbol.identityValue.value;
            parentMap.put(path, value);
        }
    }

    public static final void expand(Map<StringBuilder, String> parentMap, Variation variation) {
        StringBuilder path = new StringBuilder();
        Map<KindRole, GoalRole> variationMap = variation.goalRoles;
        for (Map.Entry<KindRole, GoalRole> entrySet : variationMap.entrySet()) {
            //KindRole kindRole = entrySet.getKey();
            GoalRole goalRole = entrySet.getValue();
            Map<StringBuilder, String> childmap = new HashMap<StringBuilder, String>();
            expand(childmap, goalRole);
            for (Map.Entry<StringBuilder, String> childEntry : childmap.entrySet()) {
                StringBuilder key = childEntry.getKey();
                String value = childEntry.getValue();
                StringBuilder childPath = new StringBuilder(path.toString());
                //childPath.append("/");
                childPath.append(key.toString());
                parentMap.put(childPath, value);
            }
        }

    }

}
