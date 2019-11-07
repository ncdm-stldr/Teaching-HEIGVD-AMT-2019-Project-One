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
import javax.ejb.Stateless;

/**
 *
 * @author NS
 */
@Stateless
public class CentersOfInterestService {

    //TODO replace this with real data taken from database
    public Collection<CenterOfInterest> getNCentersOfInterest(int n) {
        List<CenterOfInterest> list = new LinkedList<>();
        for(int id = 0; id < n; ++id){
            list.add(new CenterOfInterest("center of interest n° " + id,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
                            + " sed do eiusmod tempor incididunt ut labore et"
                            + " dolore magna aliqua. Ut enim ad minim veniam, "
                            + "quis nostrud exercitation ullamco laboris nisi "
                            + "ut aliquip ex ea commodo consequat. Duis aute "
                            + "irure dolor in reprehenderit in voluptate velit"
                            + " esse cillum dolore eu fugiat nulla pariatur."
                            + " Excepteur sint occaecat cupidatat non proident,"
                            + " sunt in culpa qui officia deserunt mollit"
                            + " anim id est laborum."));
        }
        return list;
    }
    
    public CenterOfInterest getRandomCenterOfInterest() {
        return new CenterOfInterest("title", "description...");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}
