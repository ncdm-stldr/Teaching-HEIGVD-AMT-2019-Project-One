/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.services;

import ch.heigvd.amt.affinitiesnetwork.model.Affinity;
import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class UsersService implements UsersServiceLocal {
    
    @Resource(lookup = "jdbc/affinitiesNetwork")
    private DataSource dataSource;
    
    public User getUser(long id){
        User user;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT user_id, firstName, lastName FROM amt_user WHERE user_id = " + id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                long user_id = rs.getLong("user_id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                user = new User(user_id, firstName, lastName);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM amt_user");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                long user_id = rs.getLong("user_id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                users.add(new User(user_id, firstName, lastName));
                connection.close();
            }
        } catch(SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    @Override
    public long numberOfCenterOfInterest(){
        long n = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) FROM amt_centerOfInterest");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                n = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public List<CenterOfInterest> getUserCenterOfInterests(long id) {
        List<CenterOfInterest> centerOfInterests = new ArrayList<>();
        
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT coi_id, coi_name, description FROM amt_centerOfInterest" +
                                                                  "INNER JOIN amt_affinity ON amt_centerOfInterest.coi_id = amt_affinity.coi_id" +
                                                                  "WHERE user_id = " + id + ";");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {           
                String coi_id = rs.getString("coi_id");
                String coi_name = rs.getString("coi_name");
                String description = rs.getString("description");
            }
        } catch(SQLException ex) {
            Logger.getLogger(UsersService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return centerOfInterests;
    }
}
