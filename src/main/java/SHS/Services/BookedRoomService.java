/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS.Services;

/**
 *
 * @author User
 */

import java.util.ArrayList;
import java.util.List;
import main.java.SHS.FileHandlers.*;
import main.java.SHS.BookedRoom;

public class BookedRoomService {
    private static BookedRoomService bookedRoomService;

    public static BookedRoomService getBookedRoomService() {
        // Not instantiated yet
        if (bookedRoomService == null) {
            bookedRoomService = new BookedRoomService();
        }
        return bookedRoomService;
    }

    public static void offBookedRoomService() {
        bookedRoomService = null;
    }

    private ArrayList<BookedRoom> bookedRooms;
    private FileHandler bookedRoomFile = new FileHandler(FileName.BOOKED_ROOM);

    public BookedRoomService() {
        this.bookedRooms = new ArrayList<BookedRoom>();

        List<FileRecord> bookedRoomRecords = bookedRoomFile.FetchRecord();
        bookedRoomRecords.forEach((record) -> {
            BookedRoom bookedRoomObject = convertToObject(record);
            this.bookedRooms.add(bookedRoomObject);
        });
        System.out.println(bookedRooms);
        this.bookedRooms.forEach((record) -> System.out.println(record.getRoomNumber()));
    }

    private BookedRoom convertToObject(FileRecord r) {
        String[] roomData = r.getRecordList();
        if (roomData.length == 0) {
            return null;
        }
        int bookedRoomID = Integer.parseInt(roomData[0]);
        int studentID = Integer.parseInt(roomData[1]);
        String studentName = roomData[2];
        int applicationID = Integer.parseInt(roomData[3]);
        int paymentID = Integer.parseInt(roomData[4]);
        String startDate = roomData[5];
        String endDate = roomData[6];
        int los = Integer.parseInt(roomData[7]);
        String status = roomData[8];
        int roomNumber = Integer.parseInt(roomData[9]);
        String roomType = roomData[10];
        String furnish = roomData[11];
        String availability = roomData[12];
        int price = Integer.parseInt(roomData[13]);

        return new BookedRoom(bookedRoomID, studentID, studentName, applicationID, paymentID, startDate, endDate, los, status, roomNumber, roomType, furnish, availability, price);
    }

    private FileRecord convertToFileRecord(BookedRoom bookedRoom) {
        String roomRecordString = bookedRoom.getBookedRoomID() + ";" + bookedRoom.getStudentID() + ";" + bookedRoom.getStudentName() + ";" + bookedRoom.getApplicationID() + ";" + bookedRoom.getPaymentID() + ";" + bookedRoom.getStartDate() + ";" + bookedRoom.getEndDate() + ";" + bookedRoom.getLos() + ";" + bookedRoom.getStatus() + ";" + bookedRoom.getRoomNumber() + ";" + bookedRoom.getRoomType() + ";" + bookedRoom.getFurnish() + ";" + bookedRoom.getAvailability() + ";" + bookedRoom.getPrice();
        return new FileRecord(bookedRoom.getBookedRoomID(), roomRecordString);
    }

    public int getNewBookedRoomID() {
        return bookedRoomFile.GenerateID();
    }

    public ArrayList<BookedRoom> getBookedRooms() {
        return this.bookedRooms;
    }

    public BookedRoom getLatestBookedRoom(String studentName) {
        List<FileRecord> records = bookedRoomFile.FetchRecord();

        for (int i = records.size() - 1; i >= 0; i--) {
            FileRecord record = records.get(i);
            String[] data = record.getRecord().split(";");

            if (data[2].equals(studentName)) {
                int bookedRoomID = Integer.parseInt(data[0]);
                int studentID = Integer.parseInt(data[1]);
                int applicationID = Integer.parseInt(data[3]);
                int paymentID = Integer.parseInt(data[4]);
                String startDate = data[5];
                String endDate = data[6];
                int los = Integer.parseInt(data[7]);
                String status = data[8];
                int roomNumber = Integer.parseInt(data[9]);
                String roomType = data[10];
                String furnish = data[11];
                String availability = data[12];
                int price = Integer.parseInt(data[13]);

                BookedRoom bookedRoom = new BookedRoom(bookedRoomID, studentID, studentName, applicationID, paymentID, startDate, endDate, los, status, roomNumber, roomType, furnish, availability, price);
                return bookedRoom;
            }
        }

    return null;
}
    
    public BookedRoom getLatestBookedRoom(int RoomID) {
        List<FileRecord> records = bookedRoomFile.FetchRecord();

        for (int i = records.size() - 1; i >= 0; i--) {
            FileRecord record = records.get(i);
            String[] data = record.getRecord().split(";");

            if (RoomID==Integer.parseInt(data[9])) {
                int bookedRoomID = Integer.parseInt(data[0]);
                int studentID = Integer.parseInt(data[1]);
                String studentName = data[2];
                int applicationID = Integer.parseInt(data[3]);
                int paymentID = Integer.parseInt(data[4]);
                String startDate = data[5];
                String endDate = data[6];
                int los = Integer.parseInt(data[7]);
                String status = data[8];
                int roomNumber = Integer.parseInt(data[9]);
                String roomType = data[10];
                String furnish = data[11];
                String availability = data[12];
                int price = Integer.parseInt(data[13]);

                BookedRoom bookedRoom = new BookedRoom(bookedRoomID, studentID, studentName, applicationID, paymentID, startDate, endDate, los, status, roomNumber, roomType, furnish, availability, price);
                return bookedRoom;
            }
        }

    return null;
}


    public BookedRoom getBookedRoom(int id) {
        BookedRoom response = null;
        for (int i = 0; i < bookedRooms.size(); i++) {
            if (bookedRooms.get(i).getBookedRoomID() == id) {
                response = bookedRooms.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("No such record in this \"room\". FIND A WAY TO HANDLE**");
        }
        return response;
    }

    public void addBookedRoom(BookedRoom bookedRoom) {
        this.bookedRooms.add(bookedRoom);
        FileRecord roomRecord = convertToFileRecord(bookedRoom);
        bookedRoomFile.InsertRecord(roomRecord);
    }

    public void updateBookedRoom(BookedRoom bookedRoom) {
        for (int i = 0; i < bookedRooms.size(); i++) {
            if (bookedRooms.get(i).getBookedRoomID() == bookedRoom.getBookedRoomID()) {
                bookedRooms.set(i, bookedRoom);
                FileRecord roomRecord = convertToFileRecord(bookedRoom);
                bookedRoomFile.UpdateRecord(roomRecord);
                break;
            }
        }
    }


    public void deleteBookedRoom(BookedRoom bookedRoom) {
        for (int i = 0; i < bookedRooms.size(); i++) {
            if (bookedRooms.get(i).getBookedRoomID() == bookedRoom.getBookedRoomID()) {
                // Remove from booked room object
                bookedRooms.remove(bookedRooms.get(i));
                // Remove from Booked Room Text file
                FileRecord roomRecord = convertToFileRecord(bookedRoom);
                bookedRoomFile.DeleteRecord(roomRecord);
                break;
            }
        }
    }
    
    
public boolean checkExistingBooking(String studentName) {
    List<FileRecord> records = bookedRoomFile.FetchRecord();

    for (int i = records.size() - 1; i >= 0; i--) {
        FileRecord record = records.get(i);
        String[] data = record.getRecord().split(";");

        if (data[2].equals(studentName)) {
            if (!data[8].equals("Active")) {
                return false; // First matching record found, but status is not "Active"
            }
            return true; // First matching record found with "Active" status
        }
    }

    return false; // No matching record found
}

public boolean checkBookingExist(String studentName) {
    List<FileRecord> records = bookedRoomFile.FetchRecord();

    for (int i = records.size() - 1; i >= 0; i--) {
        FileRecord record = records.get(i);
        String[] data = record.getRecord().split(";");

        if (data[2].equals(studentName)) {
            return true; // First matching record found with "Active" status
        }
    }

    return false; // No matching record found
}


public boolean checkBookingExist(int RoomID) {
    List<FileRecord> records = bookedRoomFile.FetchRecord();

    for (int i = records.size() - 1; i >= 0; i--) {
        FileRecord record = records.get(i);
        String[] data = record.getRecord().split(";");

        if (RoomID==Integer.parseInt(data[9])) {
            return true; // First matching record found with "Active" status
        }
    }

    return false; // No matching record found
}
}

