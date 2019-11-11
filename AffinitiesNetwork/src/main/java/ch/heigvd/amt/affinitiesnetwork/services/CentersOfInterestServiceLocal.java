/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon
 */
@Local
public interface CentersOfInterestServiceLocal {

    public List<CenterOfInterest> getNRandomCOI(int n); 
}
