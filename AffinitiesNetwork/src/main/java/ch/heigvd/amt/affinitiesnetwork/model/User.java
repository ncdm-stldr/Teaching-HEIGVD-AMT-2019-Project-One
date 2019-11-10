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
    private String firstName;
    private String lastName;
    private Collection<Affinity> affinities;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Collection<Affinity> getAffinities() {
        return affinities;
    }

    public void addAffinity(Affinity affinities) {
        this.affinities.add(affinities);
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null || o instanceof User) return false;
        return id == ((User) o).id;
    }
    
    @Override
    public int hashCode(){
        return (int) id;
    }
    
    
}
