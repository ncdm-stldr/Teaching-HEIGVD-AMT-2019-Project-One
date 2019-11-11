/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Simon
 */
@Stateless
public class AffinityService implements AffinityServiceLocal {
    
    @Resource(lookup = "jdbc/affinitiesNetwork")
    private DataSource dataSource;
    
    @Override
    public void addAffinity(int affinityLevel, int user_id, int coi_id) {
        
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO amt_affinity(affinity_level, user_id, coi_id) VALUES (?, ?, ?)");
            pstmt.setLong(1, affinityLevel);
            pstmt.setLong(2, user_id);
            pstmt.setLong(3, coi_id);
            ResultSet rs = pstmt.executeQuery();

            connection.close();
            
        } catch(SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
