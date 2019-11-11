/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import javax.ejb.Local;

/**
 *
 * @author Simon
 */
@Local
public interface AffinityServiceLocal {
    public void addAffinity(int affinityLevel, int user_id, int coi_id);
}
