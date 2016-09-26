/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.lexia.core.LexiaIs;
import org.lexia.core.OhNo;
import org.lexia.core.Oops;
import org.lexia.core.SayWhat;
import org.lexia.core.format.MemberListFormat;
import org.lexia.core.method.Action;
import org.lexia.core.goal.Goal;
import org.lexia.core.kind.DomainSet;
import org.lexia.core.kind.Kind;
import org.lexia.core.role.KindRole;
import org.lexia.core.role.ActionRole;
import org.lexia.core.role.RoleName;
import org.lexia.core.scope.Scope;
import org.lexia.core.scope.ScopeName;

/**
 *
 * @author genesis
 */
public class LEX69 implements LexiaIs {

    private final Map<String, Goal> goalsByGoal = new HashMap<>();

    private final MemberListFormat listFormat;
    public LEX69(MemberListFormat listFormat) {
        this.listFormat = listFormat;
    }
    
    public final MemberListFormat listFormat() {
        return this.listFormat;
    }

    public Goal[] GET(Scope scope) {
        System.out.println("KIND: " + scope.methodRole.action.goal.kind.toURI(this.listFormat));
        System.out.println("GOAL: " + scope.methodRole.action.goal.toURI(this.listFormat));
        System.out.println("METHOD: " + scope.methodRole.action.toURI(this.listFormat));
        System.out.println("SCOPE: " + scope.toURI(this.listFormat));
        List<Goal> goalList = new ArrayList();
        //
        //
            Goal methodGoal = scope.methodRole.action.goal;
            String url = methodGoal.toURI(this.listFormat);
            if (ScopeName.THE_THING.name.equals(scope.scopeName.name)) {
                if (goalsByGoal.containsKey(url)) {
                } else {
                    throw new SayWhat(OhNo.NONE_FOUND, methodGoal,this.listFormat);
                }
            } else if (ScopeName.A_THING.name.equals(scope.scopeName.name)) {
                if (goalsByGoal.containsKey(url)) {
                } else {
                    expand(scope);
                    goalsByGoal.put(url, methodGoal);
                }
            } else if (ScopeName.NO_ALLOWED_THING.name.equals(scope.scopeName.name)) {
                return goalList.toArray(new Goal[goalList.size()]);
            } else if (ScopeName.NOT_THE_THING.name.equals(scope.scopeName.name)) {
                return goalList.toArray(new Goal[goalList.size()]);
            } else if (ScopeName.ANY_MATCHING_THING.name.equals(scope.scopeName.name)) {
                return goalList.toArray(new Goal[goalList.size()]);
            } else {
                throw new Oops(OhNo.NOT_SUPPORTED, scope);
            }
            Goal exist = goalsByGoal.get(url);
            System.out.println("EXIST: " + exist.toURI(this.listFormat));
            goalList.add(exist);
            return goalList.toArray(new Goal[goalList.size()]);
    }

    private void expand(Scope scope) {
        Set<Scope> groupScopes = scope.methodRole.action.reach.scopes;
        for (Scope groupScope : groupScopes) {
            Goal[] groupGoals = this.GET(groupScope);
        }
    }

    public static Scope Scope(ScopeName scopeName,RoleName roleName, Action method) {
        return Scope.instance(scopeName,ActionRole.instance(roleName, method));
    }
    public static Scope A(RoleName roleName, Action method) {
        return Scope.A(ActionRole.instance(roleName, method));
    }

    public static final Scope THE(RoleName roleName, Action method) {
        return Scope.THE(ActionRole.instance(roleName, method));
    }

    public static final KindRole FROM(Kind kind) {
        return KindRole.FROM(kind);
    }

    public final Action NAME(DomainSet domainSet, String name, boolean not) {
        return ActionLEX69.NAME(domainSet,name, not);
    }

    public final Action CONEXT(DomainSet domainSet, String name, boolean not) {
        return ActionLEX69.CONTEXT(domainSet,name, not);
    }
    /*public static final Method KIND(String name) {
        return MethodLEX69.A_KIND(name);
    }*/

    public static final Action USER(String name) {
        return ActionLEX69.USER(name);
    }

    public final Action TYPE(DomainSet domainSet,Long id, String name) {
        return ActionLEX69.A_TYPE(domainSet,id, name);
    }

    public final Action NODE(DomainSet domainSet, String type, String name) {
        return ActionLEX69.A_NODE(domainSet, type, name);
    }

    public final Action LINK(DomainSet fromDomain, String fromType, String fromName,DomainSet toDomain, String toType, String toName, String name) {
        return ActionLEX69.LINK(fromDomain, fromType, fromName,toDomain, toType, toName, name);
    }

    public final Action ROLE(DomainSet fromDomain, String fromType, String fromName, String contextName, String methodName) {
        return ActionLEX69.ROLE(fromDomain, fromType, fromName, contextName, methodName);
    }

    public static final Action REQUEST(String user, String timestamp, String symbol) {
        return ActionLEX69.A_REQUEST(user, timestamp, symbol);
    }

    public static final Action LINK_FLAG(String contextName,String userName,String flagType,String flagOption, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        return ActionLEX69.LINK_FLAG(contextName, userName,flagType,flagOption, fromDomain, fromType, fromName, toDomain, toType, toName, name);
    }

    public static final Action LINK_TOUCH(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        return ActionLEX69.LINK_TOUCH(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name);
    }

    public static final Action LINK_IMAGE(String requestSymbol, DomainSet fromDomain, String fromType, String fromName, DomainSet toDomain, String toType, String toName, String name) {
        return ActionLEX69.LINK_IMAGE(requestSymbol, fromDomain, fromType, fromName, toDomain, toType, toName, name);
    }

    public static void main(String[] args) {
        LEX69 lexia = new LEX69(KindListFormat.URL_PATH);

        Scope aNameFluffy = A(RoleName.WITH, lexia.NAME(DomainSet.SYSTEM_COMPLIMENT_SET, "Fluffy", false));
        System.out.println("\nA(RoleName.BLANK, NAME(\"Fluffy\", false)):\n" + aNameFluffy.toURI(lexia.listFormat));
        Goal[] goals = lexia.GET(aNameFluffy);
        for (Goal goal : goals) {
            System.out.println("\nA(RoleName.BLANK, NAME(\"Fluffy\", false)):" + goal.toURI(lexia.listFormat));
        }
    }

    @Override
    public Goal[] HEAD(Scope scope) {
        throw new Oops("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Goal[] PUT(Scope scope) {
        throw new Oops("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Goal[] POST(Scope scope) {
        throw new Oops("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Goal[] DELETE(Scope scope) {
        throw new Oops("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Goal[] OPTIONS(Scope scope) {
        throw new Oops("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
