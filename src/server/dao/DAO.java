/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public abstract class DAO {
    
    protected Connection connection;

    public DAO() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/btl?useSSL=false", "root", "1234");
            System.out.println("Thanh cong");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Khoong thanh cong");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
