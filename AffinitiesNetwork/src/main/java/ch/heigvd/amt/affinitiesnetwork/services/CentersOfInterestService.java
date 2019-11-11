/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author NS
 */
@Stateless
public class CentersOfInterestService implements CentersOfInterestServiceLocal {
    
    @Resource(lookup = "jdbc/affinitiesNetwork")
    private DataSource dataSource;
    
    @Override
    public List<CenterOfInterest> getNRandomCOI(int n) {
        List<CenterOfInterest> centerOfInterest = new LinkedList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM amt_centerOfInterest WHERE random() < (" + n 
                                                                + "/ (SELECT count(1) FROM amt_centerOfInterest)) limit " + n);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                long coi_id = rs.getLong("coi_id");
                String coi_name = rs.getString("coi_name");
                String description = rs.getString("description");
                centerOfInterest.add(new CenterOfInterest(coi_id, coi_name, description));
                connection.close();
            }
        } catch(SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centerOfInterest;
    }
}
