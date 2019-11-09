/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NS
 */
@Stateless
public class CentersOfInterestService {
    
    @EJB
    private InMemoryDatabase db;

    //TODO replace this with real data taken from database
    public Collection<CenterOfInterest> getNRandomCentersOfInterest(int n) {
        return db.getNRandomCentersOfInterest(n);
    }
    
    public CenterOfInterest getCenterOfInterest(long id){
        return db.getCenterOfInterest(id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}
