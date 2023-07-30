/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.exception.EmptyStringException;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Floor;
import model.Room;

/**
 *
 * @author Administrator
 */
public class ClientView extends javax.swing.JFrame {

    /**
     * Creates new form ClientView
     */
    private Room room;

    private Floor floor;

    public ClientView() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        roomForm.setLocationRelativeTo(this);
        roomForm.setResizable(false);
        floorForm.setLocationRelativeTo(this);
        floorForm.setResizable(false);

        room = new Room();
        floor = new Floor();
        
        
    }

    public void addActionListener(ActionListener actionListener) {

        roomSearch.addActionListener(actionListener);
        roomCreate.addActionListener(actionListener);
        roomDelete.addActionListener(actionListener);
        roomUpdate.addActionListener(actionListener);
        applyRoomBtn.addActionListener(actionListener);

        floorSearch.addActionListener(actionListener);
        floorCreate.addActionListener(actionListener);
        floorDelete.addActionListener(actionListener);
        floorUpdate.addActionListener(actionListener);
        applyFloorbtn.addActionListener(actionListener);

    }

    public void addItems(List<Integer> floors) {
        for (Integer i : floors) {
            floorId.addItem(i);
        }
    }

    public Room getRoom() throws NumberFormatException, EmptyStringException {
        int floor = (int) floorId.getSelectedItem();

        if (roomArea.getText().equals("") || roomName.getText().equals("") || roomPopulation.getText().equals("")) {
            throw new EmptyStringException("Hãy nhập đủ các trường");
        }
        String name = roomName.getText();

        float area = Float.parseFloat(roomArea.getText().toString());

        int population = Integer.parseInt(roomPopulation.getText().toString());

        room.setName(name);
        room.setFloorId(floor);
        room.setArea(area);
        room.setPopulationOfRoom(population);
       
        return room;
    }

    public Floor getFloor() throws NumberFormatException, EmptyStringException {

        if (floorName.getText().equals("") || floorDecrip.getText().equals("")) {
            throw new EmptyStringException("Hãy nhập đủ các trường");
        }
        String name = floorName.getText();

        String decription = floorDecrip.getText().toString();

        floor.setName(name);
        floor.setDecription(decription);
       
        return floor;
    }

    public int getRoomId() throws NumberFormatException, EmptyStringException {
        if (roomId.getText().equals("")) {
            throw new EmptyStringException("Nhập trường ID!!!");
        }

        int id = Integer.parseInt(roomId.getText().toString());

        return id;
    }

    public int getFloorId() throws NumberFormatException, EmptyStringException {
        if (floorIdtf.getText().equals("")) {
            throw new EmptyStringException("Nhập trường ID!!!");
        }

        int id = Integer.parseInt(floorIdtf.getText().toString());

        return id;
    }

    public void setRoomForm(Room room) {
        roomName.setText(room.getName());
        roomArea.setText(room.getArea() + "");
        roomPopulation.setText(room.getPopulationOfRoom() + "");
        floorId.setSelectedItem(room.getFloorId());
        floorId.setEnabled(false);
    }

    public void setFloorForm(Floor floor) {
        floorName.setText(floor.getName());
        floorDecrip.setText(floor.getDecription());

    }

    public void showRoomInfo(Room room) {
        floorLb.setText("Floor : " + room.getFloorId());
        nameLb.setText("Name : " + room.getName());
        areaLb.setText("Area : " + room.getArea());
        populationLb.setText("Population : " + room.getPopulationOfRoom());

    }

    public void clearRoomInfo() {
        floorLb.setText("");
        nameLb.setText("");
        areaLb.setText("");
        populationLb.setText("");

    }

    public void showFloorInfo(Floor floor) {
        nameFloorlb.setText("Name : " + floor.getName());
        decriptionlb.setText("Decription : " + floor.getDecription());

    }

    public void clearFloorInfo() {
        nameFloorlb.setText("");
        decriptionlb.setText("");

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JButton getApplyRoomBtn() {
        return applyRoomBtn;
    }

    public JDialog getFloorForm() {
        return floorForm;
    }

    public JButton getRoomCreate() {
        return roomCreate;
    }

    public JButton getRoomDelete() {
        return roomDelete;
    }

    public JDialog getRoomForm() {
        return roomForm;
    }

    public JButton getRoomSearch() {
        return roomSearch;
    }

    public JButton getRoomUpdate() {
        return roomUpdate;
    }

    public JButton getApplyFloorbtn() {
        return applyFloorbtn;
    }

    public JButton getFloorCreate() {
        return floorCreate;
    }

    public JButton getFloorDelete() {
        return floorDelete;
    }

    public JButton getFloorSearch() {
        return floorSearch;
    }

    public JButton getFloorUpdate() {
        return floorUpdate;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomForm = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        floorId = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        roomName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        roomArea = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        roomPopulation = new javax.swing.JTextField();
        applyRoomBtn = new javax.swing.JButton();
        floorForm = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        floorName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        floorDecrip = new javax.swing.JTextField();
        applyFloorbtn = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nameFloorlb = new javax.swing.JLabel();
        decriptionlb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        floorIdtf = new javax.swing.JTextField();
        floorSearch = new javax.swing.JButton();
        floorUpdate = new javax.swing.JButton();
        floorCreate = new javax.swing.JButton();
        floorDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        floorLb = new javax.swing.JLabel();
        nameLb = new javax.swing.JLabel();
        areaLb = new javax.swing.JLabel();
        populationLb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        roomId = new javax.swing.JTextField();
        roomSearch = new javax.swing.JButton();
        roomUpdate = new javax.swing.JButton();
        roomCreate = new javax.swing.JButton();
        roomDelete = new javax.swing.JButton();

        roomForm.setResizable(false);
        roomForm.setSize(new java.awt.Dimension(480, 400));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ROOM FORM");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Floor");

        jLabel4.setText("Name");

        jLabel5.setText("Area");

        jLabel6.setText("Population");

        roomPopulation.setText("0");

        applyRoomBtn.setText("Apply");

        javax.swing.GroupLayout roomFormLayout = new javax.swing.GroupLayout(roomForm.getContentPane());
        roomForm.getContentPane().setLayout(roomFormLayout);
        roomFormLayout.setHorizontalGroup(
            roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomFormLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roomFormLayout.createSequentialGroup()
                        .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(floorId, 0, 171, Short.MAX_VALUE)
                            .addComponent(roomName)
                            .addComponent(roomArea)
                            .addComponent(roomPopulation))))
                .addGap(110, 110, 110))
            .addGroup(roomFormLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(applyRoomBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomFormLayout.setVerticalGroup(
            roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(floorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roomArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(roomFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(roomPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(applyRoomBtn)
                .addContainerGap())
        );

        floorForm.setSize(new java.awt.Dimension(444, 318));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FLOOR FORM");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setText("Name");

        jLabel10.setText("Decription");

        applyFloorbtn.setText("Apply");

        javax.swing.GroupLayout floorFormLayout = new javax.swing.GroupLayout(floorForm.getContentPane());
        floorForm.getContentPane().setLayout(floorFormLayout);
        floorFormLayout.setHorizontalGroup(
            floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floorFormLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(applyFloorbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, floorFormLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(floorFormLayout.createSequentialGroup()
                        .addGroup(floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floorName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(floorDecrip, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(110, 110, 110))
        );
        floorFormLayout.setVerticalGroup(
            floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floorFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(floorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(floorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(floorDecrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(applyFloorbtn)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameFloorlb, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(decriptionlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(nameFloorlb)
                .addGap(72, 72, 72)
                .addComponent(decriptionlb)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jLabel12.setText("ID");

        floorSearch.setText("Search");

        floorUpdate.setText("Update");

        floorCreate.setText("Create");

        floorDelete.setText("Delete");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(floorDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(floorSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floorUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(floorCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floorIdtf, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(floorIdtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(floorSearch)
                        .addGap(38, 38, 38)
                        .addComponent(floorUpdate)
                        .addGap(33, 33, 33)
                        .addComponent(floorDelete)
                        .addGap(37, 37, 37)
                        .addComponent(floorCreate))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        tab.addTab("Floor", jPanel7);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(floorLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(areaLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(populationLb, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(floorLb)
                .addGap(72, 72, 72)
                .addComponent(nameLb)
                .addGap(67, 67, 67)
                .addComponent(areaLb)
                .addGap(71, 71, 71)
                .addComponent(populationLb)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel1.setText("ID");

        roomSearch.setText("Search");

        roomUpdate.setText("Update");

        roomCreate.setText("Create");

        roomDelete.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(roomSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(roomCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomId, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(roomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(roomSearch)
                        .addGap(51, 51, 51)
                        .addComponent(roomUpdate)
                        .addGap(47, 47, 47)
                        .addComponent(roomDelete)
                        .addGap(56, 56, 56)
                        .addComponent(roomCreate))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        tab.addTab("Room", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyFloorbtn;
    private javax.swing.JButton applyRoomBtn;
    private javax.swing.JLabel areaLb;
    private javax.swing.JLabel decriptionlb;
    private javax.swing.JButton floorCreate;
    private javax.swing.JTextField floorDecrip;
    private javax.swing.JButton floorDelete;
    private javax.swing.JDialog floorForm;
    private javax.swing.JComboBox<Integer> floorId;
    private javax.swing.JTextField floorIdtf;
    private javax.swing.JLabel floorLb;
    private javax.swing.JTextField floorName;
    private javax.swing.JButton floorSearch;
    private javax.swing.JButton floorUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel nameFloorlb;
    private javax.swing.JLabel nameLb;
    private javax.swing.JLabel populationLb;
    private javax.swing.JTextField roomArea;
    private javax.swing.JButton roomCreate;
    private javax.swing.JButton roomDelete;
    private javax.swing.JDialog roomForm;
    private javax.swing.JTextField roomId;
    private javax.swing.JTextField roomName;
    private javax.swing.JTextField roomPopulation;
    private javax.swing.JButton roomSearch;
    private javax.swing.JButton roomUpdate;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
