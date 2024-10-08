/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

import java.util.Date;
/**
 *
 * @author User
 */
public class Application {
    private int applicationID;
    private String studentName;
    private int studentId;
    private int RoomId;
    private String startDate;
    private String endDate;
    private int los;
    private String status;

    public Application(int applicationID, String studentName, int studentId, int RoomId, String startDate, String endDate, int los, String status) {
        this.applicationID = applicationID;
        this.studentName = studentName;
        this.studentId = studentId;
        this.RoomId = RoomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.los = los;
        this.status = status;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getRoomId() {
        return RoomId;
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

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setRoomId(int RoomId) {
        this.RoomId = RoomId;
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
        return "Application{" + "applicationID=" + applicationID + ", studentName=" + studentName + ", studentId=" + studentId + ", RoomId=" + RoomId + ", startDate=" + startDate + ", endDate=" + endDate + ", los=" + los + ", status=" + status + '}';
    }


}

