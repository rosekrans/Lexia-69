/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.HashSet;
import java.util.Set;
import org.lexia.core.OhNo;
import org.lexia.core.Oops;
import org.lexia.core.format.MemberListFormat;
import org.lexia.core.goal.Goal;
import org.lexia.core.kind.DomainSet;
import org.lexia.core.method.Action;
import org.lexia.core.method.Reach;
import org.lexia.core.role.ActionRole;
import org.lexia.core.scope.Scope;

/**
 *
 * @author genesis
 */
public class ActionLEX69 extends Action {

    public ActionLEX69(Goal goal, Reach reach) {
        super(goal, reach);
    }

    public static final Action NAME(DomainSet domainSet, String value, boolean not) {
        Reach reach = new Reach();
        if (not) {
            Goal goal = GoalLEX69.NOT_NAME(domainSet, value);
            return instance(goal, reach);
        } else {
            Goal goal = GoalLEX69.NAME(domainSet, value);
            return instance(goal, reach);
        }
    }

    public static final Action METHOD(DomainSet domainSet, String value, boolean not) {
        Reach reach = new Reach();
        if (not) {
            Goal goal = GoalLEX69.NOT_METHOD(domainSet, value);
            return instance(goal, reach);
        } else {
            Goal goal = GoalLEX69.METHOD(domainSet, value);
            return instance(goal, reach);
        }
    }

    public static final Action CONTEXT(DomainSet domainSet, String value, boolean not) {
        Reach reach = new Reach();
        if (not) {
            Goal goal = GoalLEX69.NOT_CONTEXT(domainSet, value);
            return instance(goal, reach);
        } else {
            Goal goal = GoalLEX69.CONTEXT(domainSet, value);
            return instance(goal, reach);
        }
    }

    public static final Action USER(String user) {
        Reach reach = new Reach();
        Goal goal = GoalLEX69.USER(user);
        return instance(goal, reach);
    }

    public static final Action TIME(String value) {
        Reach reach = new Reach();
        Goal goal = GoalLEX69.TIME(value);
        return instance(goal, reach);
    }

    public static final Action A_REQUEST(String user, String timestamp, String symbol) {
        Scope aUser = Scope.A(ActionRole.AS(ActionLEX69.USER(user)));
        Scope aTime = Scope.A(ActionRole.AS(ActionLEX69.TIME(timestamp)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(aUser);
        scopes.add(aTime);
        Reach reach = new Reach(scopes);
        return instance(GoalLEX69.REQUEST(null, aUser.methodRole.action.goal, aTime.methodRole.action.goal, symbol), reach);
    }

    public static final Action THE_REQUEST(String symbol) {
        String nullString = null;
        String nullDate = null;
        Scope aUser = Scope.ANY(ActionRole.AS(ActionLEX69.USER(nullString)));
        Scope aTime = Scope.ANY(ActionRole.AS(ActionLEX69.TIME(nullDate)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(aUser);
        scopes.add(aTime);
        Reach reach = new Reach(scopes);
        return instance(GoalLEX69.REQUEST(null, aUser.methodRole.action.goal, aTime.methodRole.action.goal, symbol), reach);
    }

    public static final Action A_TYPE(DomainSet domainSet, Long id, String name) {
        Scope nameScope = Scope.A(ActionRole.AS(ActionLEX69.NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(nameScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.TYPE(domainSet, id, name);
        return instance(goal, reach);
    }

    public static final Action THE_TYPE(DomainSet domainType, Long id, String name) {
        Scope nameScope = Scope.THE(ActionRole.AS(ActionLEX69.NAME(domainType, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(nameScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.TYPE(domainType, id, name);
        return instance(goal, reach);
    }

    public static final Action A_NODE(DomainSet domainSet, String typeName, String name) {
        Scope aType = Scope.A(ActionRole.AS(A_TYPE(domainSet, null, typeName)));
        Scope aName = Scope.A(ActionRole.AS(NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(aType);
        scopes.add(aName);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.NODE(domainSet, null, typeName, null, name);
        return instance(goal, reach);
    }

    public static final Action A_FLAG_TYPE(DomainSet domainSet, String name) {
        Scope nameScope = Scope.A(ActionRole.AS(ActionLEX69.NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(nameScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.FLAG_TYPE(domainSet, null, name);
        return instance(goal, reach);
    }

    public static final Action A_FLAG_OPTION(DomainSet domainSet, String name) {
        Scope aName = Scope.A(ActionRole.AS(NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(aName);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.FLAG_OPTION(domainSet, null, name);
        return instance(goal, reach);
    }

    public static final Action THE_NODE(DomainSet domainSet, String typeName, String name) {
        Scope aType = Scope.THE(ActionRole.AS(A_TYPE(domainSet, null, typeName)));
        Scope aName = Scope.THE(ActionRole.AS(NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(aType);
        scopes.add(aName);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.NAME(domainSet, name);
        return instance(goal, reach);
    }

    public static final Action LINK(DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        DomainSet domainSet = DomainSet.SYSTEM_COMPLIMENT_SET;
        if ((fromDomain.equals(DomainSet.SYSTEM_SET)) || (toDomain.equals(DomainSet.SYSTEM_SET))) {
            domainSet = DomainSet.SYSTEM_SET;
        }
        Scope fromNodeScope = Scope.A(ActionRole.FROM(ActionLEX69.A_NODE(fromDomain, fromType, fromName)));
        Scope toNodeScope = Scope.A(ActionRole.TO(ActionLEX69.A_NODE(toDomain, toType, toName)));
        Scope nameScope = Scope.A(ActionRole.AS(ActionLEX69.NAME(domainSet, name, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(fromNodeScope);
        scopes.add(toNodeScope);
        scopes.add(nameScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.LINK(null, fromDomain, fromType, fromName, toDomain, toType, toName, name);
        return instance(goal, reach);
    }

    public static final Action ROLE(DomainSet fromDomain, String nodeType, String nodeName, String contextName, String methodName) {
        DomainSet domainSet = DomainSet.SYSTEM_SET;
        Scope nodeScope = Scope.A(ActionRole.AS(ActionLEX69.A_NODE(fromDomain, nodeType, nodeName)));
        Scope contextScope = Scope.A(ActionRole.AS(ActionLEX69.CONTEXT(domainSet, contextName, false)));
        Scope methodScope = Scope.A(ActionRole.AS(ActionLEX69.METHOD(domainSet, methodName, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(nodeScope);
        scopes.add(contextScope);
        scopes.add(methodScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.ROLE(null, fromDomain, nodeType, nodeName, contextName, methodName);
        return instance(goal, reach);
    }

    public static final Action LINK_ROLE(DomainSet fromDomain) {
        /*DomainSet domainSet = DomainSet.SYSTEM_SET;
        Scope nodeScope = Scope.A(ActionRole.AS(ActionLEX69.A_NODE(fromDomain, nodeType, nodeName)));
        Scope contextScope = Scope.A(ActionRole.AS(ActionLEX69.CONTEXT(domainSet, contextName, false)));
        Scope methodScope = Scope.A(ActionRole.AS(ActionLEX69.METHOD(domainSet, methodName, false)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(nodeScope);
        scopes.add(contextScope);
        scopes.add(methodScope);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.LINK_ROLE(null, fromDomain, nodeType, nodeName, contextName, methodName);
        return instance(goal, reach);*/
        throw new Oops(OhNo.NOT_SUPPORTED);
    }

    public static final Action LINK_FLAG(String contextName,String userName,String flagTypeName,String flagOptionName, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        Scope flagType = Scope.THE(ActionRole.AS(ActionLEX69.A_FLAG_TYPE(toDomain,flagTypeName)));
        Scope flagOption = Scope.THE(ActionRole.AS(ActionLEX69.A_FLAG_OPTION(toDomain,flagOptionName)));
        Scope user = Scope.THE(ActionRole.AS(ActionLEX69.USER(userName)));
        Scope context = Scope.THE(ActionRole.AS(ActionLEX69.CONTEXT(toDomain,contextName,false)));
        Scope link = Scope.THE(ActionRole.AS(ActionLEX69.LINK(fromDomain, fromType, fromName, toDomain, toType, toName, name)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(flagType);
        scopes.add(flagOption);
        scopes.add(user);
        scopes.add(context);
        scopes.add(link);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.LINK_FLAG(contextName,userName,flagTypeName,flagOptionName, fromDomain, fromType, fromName, toDomain, toType, toName, name);
        return instance(goal, reach);
    }

    public static final Action LINK_TOUCH(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        Scope request = Scope.THE(ActionRole.AS(ActionLEX69.THE_REQUEST(requestSymbol)));
        Scope link = Scope.THE(ActionRole.AS(ActionLEX69.LINK(fromDomain, fromType, fromName, toDomain, toType, toName, name)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(request);
        scopes.add(link);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.LINK_TOUCH(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name);
        return instance(goal, reach);
    }

    public static final Action LINK_IMAGE(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        Scope touch = Scope.THE(ActionRole.AS(ActionLEX69.LINK_TOUCH(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name)));
        Set<Scope> scopes = new HashSet<>();
        scopes.add(touch);
        Reach reach = new Reach(scopes);
        Goal goal = GoalLEX69.LINK_IMAGE(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name);
        return instance(goal, reach);
    }

    public static void main(String[] args) {
        test(KindListFormat.LEXIA);
    }

    private static void test(MemberListFormat format) {
        //Method method = null;
        System.out.println("<>OPEN<" + format.open + ">IS<" + format.is + ">AND<" + format.and + ">CLOSE<" + format.close + ">");

        System.out.println(ActionLEX69.A_REQUEST("me", "DDay", "ABC123").toURI(format));

        System.out.println(ActionLEX69.THE_REQUEST("ABC123").toURI(format));

        System.out.println(ActionLEX69.A_REQUEST("me", "MeDay", "XYZ123").toURI(format));
    }

}
