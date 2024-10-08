/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

/**
 *
 * @author User
 */
import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private String roomType;
    private String furnish;
    private String availability;
    private int price;

    // Constructor
public Room(int roomNumber,String roomType, String furnish, String availability, int price) {
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.furnish = furnish;
    this.availability = availability;
    this.price = price;
    
}

    // Getter and setter methods
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public String getFurnish() {
        return furnish;
    }

    public void setFurnish(String furnish) {
        this.furnish = furnish;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Methods


    public String toString() {
        return  "Room Number: " + roomNumber + "\n"
                + "Room Type: " + roomType + "\n"
                + "Furnishing: " + furnish + "\n"
                + "Availability: " + availability + "\n"
                + "Price: " + price;
    }

    public int calculatePrice(int days) {
        return price * days;
    }

    public String isAvailable() {
        return availability;
    }

    public String getRoomDetails() {
        return toString();
    }



}

