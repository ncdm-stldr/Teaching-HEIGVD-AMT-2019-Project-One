/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.model;

import java.util.Collection;

/**
 *
 * @author NS
 */
public class User {
    
    private long id;
    private String name;
    private Collection<Affinity> affinities;

    public User(long id, String name, Collection<Affinity> affinities) {
        this.id = id;
        this.name = name;
        this.affinities = affinities;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Collection<Affinity> getAffinities() {
        return affinities;
    }

    public void setAffinities(Collection<Affinity> affinities) {
        this.affinities = affinities;
    }
    
    
    
}
