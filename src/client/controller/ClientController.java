/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.exception.EmptyStringException;
import client.view.ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import model.Action;
import model.Floor;
import model.Request;
import model.Room;

/**
 *
 * @author Administrator
 */
public class ClientController {
    
    private ClientView clientView;
    
    private Room room;
    
    private Floor floor;
    
    private List<Floor> floors;
    
    public static final String HOST = "localhost";
    public static final int CLIENT_PORT = 9999;
    public static final int SERVER_PORT = 1111;
    
    private DatagramSocket socket;
    
    public ClientController(ClientView clientView) {
        openConnection();
        this.clientView = clientView;
        this.clientView.setVisible(true);
        this.clientView.addActionListener(new Listener());
        setFloorID();
        
    }
    
    private void openConnection() {
        try {
            socket = new DatagramSocket(CLIENT_PORT);
        } catch (Exception ex) {
            clientView.showMessage(ex.getStackTrace().toString());
        }
    }
    
    private void sendData(Request request) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(request);
            oos.flush();
            InetAddress IPAddress = InetAddress.getByName(HOST);
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, SERVER_PORT);
            socket.send(sendPacket);
            System.out.println("sucess");
        } catch (Exception ex) {
            clientView.showMessage(ex.getStackTrace().toString());
        }
    }
    
    private Object receiveData() {
        Object object = null;
        try {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            object = ois.readObject();
        } catch (Exception ex) {
            clientView.showMessage(ex.getStackTrace().toString());
        }
        return object;
    }
    
    private void setFloorID() {
        List<Floor> floors = new ArrayList<>();
        Request request = new Request(Action.GETALL_FLOOR, null);
        sendData(request);
        
        floors = (List<Floor>) receiveData();
        List<Integer> listId = floors.stream().map(Floor::getId).collect(Collectors.toList());
        
        this.clientView.addItems(listId);
    }
    
    class Listener implements ActionListener {
        
        private Action action;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == clientView.getRoomCreate()) {
                setActionRoom(Action.CREATE_ROOM);
                
            } else if (e.getSource() == clientView.getRoomUpdate()) {
                
                try {
                    int id = clientView.getRoomId();
                    
                    Request request = new Request(Action.SEARCH_ROOM, id);
                    
                    sendData(request);
                    
                    room = (Room) receiveData();
                    
                    if (room != null) {
                        clientView.setRoomForm(room);
                        setActionRoom(Action.UPDATE_ROOM);
                    } else {
                        clientView.showMessage("ID không tồn tại!!!");
                    }
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getApplyRoomBtn()) {
                clientView.getRoomForm().dispose();
                try {
                    Room room = clientView.getRoom();
                    
                    if (action == Action.UPDATE_ROOM) {
                        room.setId(ClientController.this.room.getId());
                    }
                    
                    Request request = new Request(action, room);
                    
                    sendData(request);
                    
                    String message = (String) receiveData();
                    
                    clientView.showMessage(message);
                    
                    if (action == Action.UPDATE_ROOM) {
                        clientView.showRoomInfo(room);
                    }
                    
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng các trường!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getRoomDelete()) {
                
                try {
                    int id = clientView.getRoomId();
                    
                    Request request = new Request(Action.DELETE_ROOM, id);
                    
                    sendData(request);
                    
                    String message = (String) receiveData();
                    
                    clientView.showMessage(message);
                    clientView.clearRoomInfo();
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getRoomSearch()) {
                
                try {
                    int id = clientView.getRoomId();
                    
                    Request request = new Request(Action.SEARCH_ROOM, id);
                    
                    sendData(request);
                    
                    Room room = (Room) receiveData();
                    
                    if (room != null) {
                        clientView.showRoomInfo(room);
                        
                    } else {
                        clientView.showMessage("ID không tồn tại!!!");
                    }
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getFloorCreate()) {
                setActionFloor(Action.CREATE_FLOOR);
                
            } else if (e.getSource() == clientView.getFloorUpdate()) {
                
                try {
                    int id = clientView.getFloorId();
                    
                    Request request = new Request(Action.SEARCH_FLOOR, id);
                    
                    sendData(request);
                    
                    floor = (Floor) receiveData();
                    
                    if (floor != null) {
                        clientView.setFloorForm(floor);
                        setActionFloor(Action.UPDATE_FLOOR);
                    } else {
                        clientView.showMessage("ID không tồn tại!!!");
                    }
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getApplyFloorbtn()) {
                clientView.getFloorForm().dispose();
                try {
                    Floor floor = clientView.getFloor();
                    
                    if (action == Action.UPDATE_FLOOR) {
                        floor.setId(ClientController.this.floor.getId());
                    }
                    
                    Request request = new Request(action, floor);
                    
                    sendData(request);
                    
                    String message = (String) receiveData();
                    
                    clientView.showMessage(message);
                    
                    if (action == Action.UPDATE_FLOOR) {
                        clientView.showFloorInfo(floor);
                    }
                    
                    setFloorID();
                    
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng các trường!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getFloorDelete()) {
                
                try {
                    int id = clientView.getFloorId();
                    
                    Request request = new Request(Action.DELETE_FLOOR, id);
                    
                    sendData(request);
                    
                    String message = (String) receiveData();
                    
                    clientView.showMessage(message);
                    clientView.clearFloorInfo();
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            } else if (e.getSource() == clientView.getFloorSearch()) {
                
                try {
                    int id = clientView.getFloorId();
                    
                    Request request = new Request(Action.SEARCH_FLOOR, id);
                    
                    sendData(request);
                    
                    Floor floor = (Floor) receiveData();
                    
                    if (floor != null) {
                        clientView.showFloorInfo(floor);
                        
                    } else {
                        clientView.showMessage("ID không tồn tại!!!");
                    }
                } catch (NumberFormatException ex) {
                    clientView.showMessage("Hãy nhập đúng định dạng là số nguyên!!!");
                } catch (EmptyStringException ex) {
                    clientView.showMessage(ex.getMessage());
                }
                
            }
            
        }
        
        private void setActionRoom(Action action) {
            clientView.getRoomForm().setVisible(true);
            this.action = action;
        }
        
        private void setActionFloor(Action action) {
            clientView.getFloorForm().setVisible(true);
            this.action = action;
        }
        
    }
    
}
