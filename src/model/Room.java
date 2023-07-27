/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Room implements Serializable{
    private int id;
    private String name;
    private float area;
    private int floorId;
    private int populationOfRoom;

    public Room() {
    }

    public Room(int id, String name, float area, int floorId, int populationOfRoom) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.floorId = floorId;
        this.populationOfRoom = populationOfRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getPopulationOfRoom() {
        return populationOfRoom;
    }

    public void setPopulationOfRoom(int populationOfRoom) {
        this.populationOfRoom = populationOfRoom;
    }

   
    
    
    
}
