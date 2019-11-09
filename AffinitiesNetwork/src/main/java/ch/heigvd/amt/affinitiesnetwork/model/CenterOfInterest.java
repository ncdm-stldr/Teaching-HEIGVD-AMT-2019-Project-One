/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.model;

/**
 *
 * @author NS
 */
public class CenterOfInterest {
    
    private long id;
    private String name;
    private String description;
    
    public CenterOfInterest(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null || o instanceof CenterOfInterest) return false;
        return id == ((CenterOfInterest) o).id;
    }
    
    @Override
    public int hashCode(){
        return (int) id;
    }
    
}
