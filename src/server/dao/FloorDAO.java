/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Floor;

/**
 *
 * @author Administrator
 */
public class FloorDAO extends DAO {

    public FloorDAO() {
        super();
    }

    public void save(Floor floor) throws SQLException {
        String sql = "insert into floor(name,decription) values(?,?)";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, floor.getName());
        p.setNString(2, floor.getDecription());
        p.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        String sql = "delete from floor where id = ?";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, id);
        p.executeUpdate();

    }

    public void update(Floor floor) throws SQLException {
        String sql = "update floor set name = ?, decription = ? where id = ?";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setNString(1, floor.getName());
        p.setString(2, floor.getDecription());
        p.setInt(3, floor.getId());
        p.executeUpdate();

    }

    public List<Floor> getAll() throws SQLException {
        String sql = "SELECT * FROM FLOOR";

        PreparedStatement p = connection.prepareStatement(sql);
       
        ResultSet rs = p.executeQuery();
        
        List<Floor> floors = new ArrayList<>();
        
        while(rs.next()){
            Floor floor = new Floor(rs.getInt(1), rs.getString(2), rs.getString(3));
            floors.add(floor);
        }
        return floors;
    }
    
     public Floor getFloor(int id) throws SQLException {
        String sql = "SELECT * FROM FLOOR WHERE ID = ?";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, id);

        ResultSet rs = p.executeQuery();

        Floor floor = null;

        while (rs.next()) {
            floor = new Floor(rs.getInt(1), rs.getString(2),rs.getString(3));
        }
        return floor;
    }
    


}
