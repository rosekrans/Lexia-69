/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lexia.lex69.spec.kind;

import java.util.Collection;

/**
 *
 * @author G9020VC
 */
public interface NodeSpec<E extends TypeSpec> {
    public Boolean getDomainSet();
    public void setDomainSet(Boolean domainSet);
    public E getType();
    public void setType(E typeSpec);

/*
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Collection<Link> getLinksFrom() {
        return linksFrom;
    }

    public void setLinksFrom(Collection<Link> linksFrom) {
        this.linksFrom = linksFrom;
    }

    public Collection<NodeRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<NodeRole> roles) {
        this.roles = roles;
    }
  */  
}
