package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon
 */
@Local
public interface UsersServiceLocal {
    
    public User getUser(long id);

    public List<User> getAllUsers();
    
    //public List<CenterOfInterest> getNRandomCentersOfInterest(long n);
    
    public List<CenterOfInterest> getUserCenterOfInterests(long id);
    
    public long numberOfCenterOfInterest();
}
