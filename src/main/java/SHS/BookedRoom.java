/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

/**
 *
 * @author User
 */
public class BookedRoom extends Room {
    private int bookedRoomID;
    private int studentID;
    private String studentName;
    private int applicationID;
    private int paymentID;
    private String startDate;
    private String endDate;
    private int los;
    private String status;
    
    public BookedRoom(int roomNumber, String roomType, String furnish, String availability, int price) {
        super(roomNumber, roomType, furnish, availability, price);
    }

    public BookedRoom(int bookedRoomID, int studentID, String studentName, int applicationID, int paymentID, String startDate, String endDate, int los, String status, int roomNumber, String roomType, String furnish, String availability, int price) {
        super(roomNumber, roomType, furnish, availability, price);
        this.bookedRoomID = bookedRoomID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.applicationID = applicationID;
        this.paymentID = paymentID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.los = los;
        this.status = status;
    }

    public int getBookedRoomID() {
        return bookedRoomID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getLos() {
        return los;
    }

    public String getStatus() {
        return status;
    }

    public void setBookedRoomID(int bookedRoomID) {
        this.bookedRoomID = bookedRoomID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setLos(int los) {
        this.los = los;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookedRoom{" + "bookedRoomID=" + bookedRoomID + ", studentID=" + studentID + ", studentName=" + studentName + ", applicationID=" + applicationID + ", paymentID=" + paymentID + ", startDate=" + startDate + ", endDate=" + endDate + ", los=" + los + ", status=" + status + '}';
    }
    
    
    
}
