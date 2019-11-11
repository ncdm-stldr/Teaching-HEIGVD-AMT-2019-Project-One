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
    
<<<<<<< HEAD
    public long numberOfCenterOfInterest();
=======
    public boolean checkCredentials(long id, String username, String password);
>>>>>>> 8d6a0b2789692075ccd837d3008a5806c8d6de92
}
