/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.java.SHS.FileHandlers.FileHandler;
import main.java.SHS.FileHandlers.FileName;
import main.java.SHS.FileHandlers.FileRecord;
import main.java.SHS.Payment;

/**
 *
 * @author User
 */
public class PaymentService {
    private static PaymentService paymentService;
    private ArrayList<Payment> payments;
    private FileHandler paymentFile;
    
    
    public PaymentService() {
//        fileHandler = new FileHandler(FileName.PAYMENTS);
        this.payments = new ArrayList<>();
        this.paymentFile = new FileHandler(FileName.PAYMENTS);
        
        List<FileRecord> paymentRecords = paymentFile.FetchRecord();
        paymentRecords.forEach(record -> {
            Payment payment = convertToObject(record);
            if (payment != null) {
                this.payments.add(payment);
            }
        });
    }
    
    public static PaymentService getPaymentService() {
        if (paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }
    
    
//    public void makePayment(Payment payment) {
//        int paymentID = payment.getPaymentID();
//        int customerID = payment.getStudentID();
//        int applicationID = payment.getApplicationID();
//        int paymentAmount = payment.getPaymentAmount();
//        String paymentDate = payment.getPaymentDate();
//        
//        
//        String paymentData = paymentID + ";" +
//                customerID + ";" +
//                applicationID + ";" +
//                paymentAmount + ";" +
//                paymentDate;
//        
//        System.out.println(paymentData);
//        
//        FileRecord paymentRecord = new FileRecord(paymentID, paymentData);
//        paymentFile.InsertRecord(paymentRecord);
//        
//        System.out.println("Payment recorded successfully!");
//    }
//    
    
    public void makePayment(Payment payment) {
        this.payments.add(payment);
        FileRecord paymentRecord = convertToFileRecord(payment);
        paymentFile.InsertRecord(paymentRecord);
    }
    
    public ArrayList<Payment> getPayments() {
        return this.payments;
}
    

    private Payment convertToObject(FileRecord record) {
        String[] paymentData = record.getRecordList();
        if (paymentData.length == 0) {
            return null;
        }
        int paymentId = Integer.parseInt(paymentData[0]);
        int studentId = Integer.parseInt(paymentData[1]);
        int applicationId = Integer.parseInt(paymentData[2]);
        int paymentAmount = Integer.parseInt(paymentData[3]);
        String paymentDate = paymentData[4];

        // Create and return a new Payment object
        return new Payment(paymentId, studentId, applicationId, paymentAmount, paymentDate);
    }

    
    private FileRecord convertToFileRecord(Payment payment) {
        String paymentRecordString = payment.getPaymentID() + ";" +
        payment.getStudentID() + ";" +
        payment.getApplicationID() + ";" +
        payment.getPaymentAmount() + ";" +
        payment.getPaymentDate(); // adjust the format based on your Payment class

    return new FileRecord(payment.getPaymentID(), paymentRecordString);
}


    public Payment getPayment(int paymentId) {
        for (Payment payment : payments) {
            if (payment.getPaymentID() == paymentId) {
                return payment;
            }
        }
        return null; // Return null if payment not found
    }
    
}

