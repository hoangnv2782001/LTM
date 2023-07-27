/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.cotroller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import server.dao.DAO;
import server.dao.FloorDAO;
import server.dao.RoomDAO;

/**
 *
 * @author Administrator
 * @
 */
public class ServerController {

    private static final int SERVER_PORT = 1111;

    private DatagramSocket socket;

    private DatagramPacket packet;

    private FloorDAO floorDao;
    private RoomDAO roomDao;

    public ServerController() {
        openServer();

        this.floorDao = new FloorDAO();
        this.roomDao = new RoomDAO();
        
        listening();
    }

    private void openServer() {
        try {
            this.socket = new DatagramSocket(SERVER_PORT);
        } catch (SocketException ex) {
            System.out.println(ex.toString());
        }
    }

    private void listening() {
        Request request = null;
        while (true) {
            try {
                request = receiveData();
                
                System.out.println(request.getAction());

                switch (request.getAction()) {
                    case SEARCH_FLOOR:
                        break;
                    case CREATE_FLOOR:
                        this.floorDao.save((Floor) request.getObject());
                        sendData("sucess");
                        break;
                    case UPDATE_FLOOR:
                        this.floorDao.update((Floor) request.getObject());
                        sendData("sucess");
                        break;
                    case DELETE_FLOOR:
                        this.floorDao.delete(((int) request.getObject()));
                        sendData("sucess");
                        break;
                    case CREATE_ROOM:
                        this.roomDao.save((Room) request.getObject());
                        sendData("sucess");
                        break;
                    case UPDATE_ROOM:
                       
                        this.roomDao.update((Room) request.getObject());
                        sendData("sucess");
                        break;
                    case DELETE_ROOM:
                        this.roomDao.delete((int) request.getObject());
                        sendData("sucess");
                        break;
                    case GETALL_FLOOR:
                        List<Floor> floors = floorDao.getAll();
                        sendData(floors);
                        break;
                    case SEARCH_ROOM:
                        Room room = roomDao.getRoom((int)request.getObject());
                        sendData(room);
                        break;
                }

              
            } catch (SQLException ex) {
                System.out.println(ex.toString());
                sendData("fail");
            }
        }
    }

    private Request receiveData() {
        Request request = null;
        try {
            byte[] receiveData = new byte[1024];
            this.packet = new DatagramPacket(receiveData, receiveData.length);
            this.socket.receive(this.packet);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            request = (Request) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return request;
    }

   

    private void sendData(Object result) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(result);
            oos.flush();
            InetAddress IPAddress = this.packet.getAddress();
            int clientPort = this.packet.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, clientPort);
            this.socket.send(sendPacket);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
