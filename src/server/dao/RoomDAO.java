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
import model.Room;

/**
 *
 * @author Administrator
 */
public class RoomDAO extends DAO {

    public RoomDAO() {
        super();
    }

    public void save(Room room) throws SQLException {
        String sql = "insert into room(name,area,populationOfRoom,floor_id) values(?,?,?,?)";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, room.getName());
        p.setFloat(2, room.getArea());
        p.setInt(3, room.getPopulationOfRoom());
        p.setInt(4, room.getFloorId());
        p.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        String sql = "delete from room where id = 1";

        PreparedStatement p = connection.prepareStatement(sql);
//        p.setInt(1, id);
        p.executeUpdate();

    }

    public void update(Room room) throws SQLException {
        String sql = "update room set name = ?, area = ?, populationOfRoom = ? where id = ?";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, room.getName());
        p.setFloat(2, room.getArea());
        p.setInt(3, room.getPopulationOfRoom());
        p.setInt(4, room.getId());
        p.executeUpdate();

    }

    public Room getRoom(int id) throws SQLException {
        String sql = "SELECT * FROM ROOM WHERE ID = ?";

        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, id);

        ResultSet rs = p.executeQuery();

        Room room = null;

        while (rs.next()) {
            room = new Room(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(5), rs.getInt(4));
        }
        return room;
    }
    
//    public static void main(String[] args) {
//        RoomDAO r = new RoomDAO();
//        
//        try {
//            r.delete(1);
//            System.out.println("1234");
//        } catch (SQLException ex) {
//            System.out.println("loi");
//        }
//    }

}
