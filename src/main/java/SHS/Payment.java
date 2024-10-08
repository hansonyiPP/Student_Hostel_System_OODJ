/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

/**
 *
 * @author User
 */
import java.util.Date;

public class Payment {
    private int paymentID;
    private int studentID;
    private int applicationID;
    private int paymentAmount;
    private String paymentDate;

    public Payment(int paymentID, int customerID, int applicationID, int paymentAmount, String paymentDate) {
        this.paymentID = paymentID;
        this.studentID = customerID;
        this.applicationID = applicationID;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", customerID=" + studentID + ", applicationID=" + applicationID + ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + '}';
    }
   

}

