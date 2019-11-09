/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.Affinity;
import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.ejb.Singleton;

/**
 *
 * @author NS
 */
@Singleton
public class InMemoryDatabase {
    
    private static  HashMap<Long, User> users;
    private static  HashMap<Long, CenterOfInterest> centerOfInterests;
    private static  HashMap<Integer, Affinity> affinities;
    static {
        User u1 = new User(1, "Alice", new HashSet<>());
        User u2 = new User(2, "Kim", new HashSet<>());
        User u3 = new User(3, "John", new HashSet<>());
        User u4 = new User(4, "Virginia", new HashSet<>());
        User u5 = new User(5, "Hans", new HashSet<>());
        User u6 = new User(6, "Bob", new HashSet<>());
        
        CenterOfInterest cOI1 = new CenterOfInterest(1, "Poetry", "Poetry is"
                + " a form of literature that uses aesthetic and rhythmic"
                + " qualities of language—such as phonaesthetics, sound "
                + "symbolism, and metre—to evoke meanings in addition to,"
                + " or in place of, the prosaic ostensible meaning. ");
        
        CenterOfInterest cOI2 = new CenterOfInterest(2, "video gaming",
        "The activity of playing video or computer games. ");
        
        CenterOfInterest cOI3 = new CenterOfInterest(3, "Bitcoin",
                "A decentralized digital currency.");
        
        Affinity u1COI1 = new Affinity(u1, 5, cOI1);
        Affinity u2COI3 = new Affinity(u2, 2, cOI3);
        
        u1.addAffinity(u1COI1);
        //TODO link affinity with center of interest
        
        u2.addAffinity(u2COI3);
        //TODO link affinity with center of interest
        
        users = new HashMap<>();
        users.put(1L, u1);
        users.put(2L, u2);
        users.put(3L, u3);
        users.put(4L, u4);
        users.put(5L, u5);
        users.put(6L, u6);
        
        affinities = new HashMap<>();
        affinities.put(u1COI1.hashCode(), u1COI1);
        affinities.put(u2COI3.hashCode(), u2COI3);
        
        centerOfInterests = new HashMap<>();
        centerOfInterests.put(cOI1.getId(), cOI1);
        centerOfInterests.put(cOI2.getId(), cOI2);
        centerOfInterests.put(cOI3.getId(), cOI3);
        
    }

    public User getUser(long id){
        return users.get(id);
    }
    
    public CenterOfInterest getCenterOfInterest(long id){
        return centerOfInterests.get(id);
    }
    
    public List<CenterOfInterest> getNRandomCentersOfInterest(long n) {
       Set<Long> keys = centerOfInterests.keySet();
       ArrayList<Long> ar = new ArrayList<Long>(keys);
       LinkedList<CenterOfInterest> li = new LinkedList<>();
       int m = ar.size();
       for(int i = 0; i < n; ++i){
           li.add(centerOfInterests.get(ar.get((int) (m * Math.random()))));
       }
       return li;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
