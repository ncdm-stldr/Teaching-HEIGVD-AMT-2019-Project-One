/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.model;

import java.util.Objects;

/**
 *
 * @author NS
 */
public class Affinity {
    
    private User user;
    private int intensity;
    private CenterOfInterest centerOfInterest;

    public Affinity(User user, int intensity, CenterOfInterest centerOfInterest) {
        this.user = user;
        this.intensity = intensity;
        this.centerOfInterest = centerOfInterest;
    }

    public User getUser() {
        return user;
    }

    public int getIntensity() {
        return intensity;
    }

    public CenterOfInterest getCenterOfInterest() {
        return centerOfInterest;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null || o instanceof Affinity) return false;
        return user.getId() == ((Affinity) o).user.getId()
                && centerOfInterest.getId() ==
                ((Affinity) o).centerOfInterest.getId();
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(user.hashCode(), centerOfInterest.hashCode());
    }
    
    
}
