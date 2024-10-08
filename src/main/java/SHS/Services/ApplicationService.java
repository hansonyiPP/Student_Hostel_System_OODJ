/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS.Services;

/**
 *
 * @author User
 */
import main.java.SHS.FileHandlers.FileHandler;
import main.java.SHS.FileHandlers.FileRecord;
import main.java.SHS.FileHandlers.FileName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import main.java.SHS.Application;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import main.java.SHS.BookedRoom;
import main.java.SHS.Payment;
import main.java.SHS.Room;
import main.java.SHS.Student_Hostel_System;


public class ApplicationService {
    private static ApplicationService applicationService;
    private ArrayList<Application> applications;
    private FileHandler fileHandler;
    int StudentID;
    int RoomID;
    int AppID;
    int PaymentID;

    public ApplicationService() {
        fileHandler = new FileHandler(FileName.APPLICATIONS);
        this.applications = new ArrayList<>();

        List<FileRecord> applicationRecords = fileHandler.FetchRecord();
        applicationRecords.forEach(record -> {
            Application application = convertToObject(record);
            if (application != null) {
                this.applications.add(application);
            }
        });
    }

    
        public static ApplicationService getApplicationService() {
            if (applicationService == null) {
                applicationService = new ApplicationService();
            }
            return applicationService;
        }


    public void sendApplication(Application application) {
        int applicationId = application.getApplicationID();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String startDateString = application.getStartDate();
        String endDateString = application.getEndDate();
        String applicationData = applicationId + ";" +
                application.getStudentName() + ";" +
                application.getStudentId() + ";" +
                application.getRoomId() + ";" +
                startDateString + ";" +
                endDateString + ";" +
                application.getLos() + ";" +
                application.getStatus();
        FileRecord applicationRecord = new FileRecord(applicationId, applicationData);
        fileHandler.InsertRecord(applicationRecord);
        System.out.println("Application sent successfully!");
    }
    

    

public Application getApplication(String studentName) {
    List<FileRecord> records = fileHandler.FetchRecord();

    for (int i = records.size() - 1; i >= 0; i--) {
        FileRecord record = records.get(i);
        String[] data = record.getRecord().split(";");

        if (data[1].equals(studentName) && !data[7].equals("Deleted")) {
            int applicationID = Integer.parseInt(data[0]);
            int studentId = Integer.parseInt(data[2]);
            int roomId = Integer.parseInt(data[3]);
            String startDate = data[4];
            String endDate = data[5];
            int los = Integer.parseInt(data[6]);
            String status = data[7];

            Application application = new Application(applicationID, studentName, studentId, roomId, startDate, endDate, los, status);
            return application;
        }
    }

    return null; // Return null if no matching application is found
}


    public ArrayList<Application> getApplications() {
        return this.applications;
}

    private Application convertToObject(FileRecord record) {
        String[] applicationData = record.getRecordList();
        if (applicationData.length == 0) {
            return null;
        }
        int applicationID = Integer.parseInt(applicationData[0]);
        String studentName = applicationData[1];
        int studentId = Integer.parseInt(applicationData[2]);
        int roomId = Integer.parseInt(applicationData[3]);
        String startDate = applicationData[4];
        String endDate = applicationData[5];
        int los = Integer.parseInt(applicationData[6]);
        String status = applicationData[7];

        // Create and return a new Application object
        return new Application(applicationID, studentName, studentId, roomId, startDate, endDate, los, status);
    }


public ArrayList<Application> getApplication() {
    ArrayList<Application> applications = new ArrayList<>();
    List<FileRecord> records = fileHandler.FetchRecord();

    for (FileRecord record : records) {
        String[] data = record.getRecord().split(";");

        int applicationID = Integer.parseInt(data[0]);
        String studentName = data[1];
        int studentId = Integer.parseInt(data[2]);
        int roomId = Integer.parseInt(data[3]);
        String startDate = data[4];
        String endDate = data[5];
        int los = Integer.parseInt(data[6]);
        String status = data[7];

        Application application = new Application(applicationID, studentName, studentId, roomId, startDate, endDate, los, status);
        applications.add(application);
    }

    return applications;
}

public void updateApplication(Application application) {
    List<FileRecord> records = fileHandler.FetchRecord();

    for (int i = 0; i < records.size(); i++) {
        String[] data = records.get(i).getRecord().split(";");

        if (Integer.parseInt(data[0]) == application.getApplicationID()) {
            // Update the application in the records list
            records.set(i, convertToFileRecord(application));
            
            // Update the record in the file
            fileHandler.UpdateRecord(records.get(i));
            
            // Exit the loop as the application has been found and updated
            break;
        }
    }
}

private FileRecord convertToFileRecord(Application application) {
    String applicationRecordString = application.getApplicationID() + ";" +
            application.getStudentName() + ";" +
            application.getStudentId() + ";" +
            application.getRoomId() + ";" +
            application.getStartDate() + ";" +
            application.getEndDate() + ";" +
            application.getLos() + ";" +
            application.getStatus();

    return new FileRecord(application.getApplicationID(), applicationRecordString);
}

public void updateApplication(int applicationID, String newStatus) {
    List<FileRecord> records = fileHandler.FetchRecord();

    for (FileRecord record : records) {
        String[] data = record.getRecord().split(";");

        if (Integer.parseInt(data[0]) == applicationID) {
            // Update the status of the matching application
            data[7] = newStatus;

            // Reconstruct the updated application record
            String updatedRecord = String.join(";", data);

            // Create a new FileRecord with the updated record
            FileRecord updatedApplicationRecord = new FileRecord(applicationID, updatedRecord);

            // Update the application record in the file
            fileHandler.UpdateRecord(updatedApplicationRecord);

            // Exit the loop since the application is found and updated
            break;
        }
    }
}

    
    public boolean checkExistingApplication(String studentName) {
    List<FileRecord> records = fileHandler.FetchRecord();

    for (FileRecord record : records) {
        String[] data = record.getRecord().split(";");

        if (data[1].equals(studentName) && (data[7].equals("Pending") || data[7].equals("Awaiting Payment") || data[7].equals("Paid"))) {
            return true; // Existing application found with matching username and false approval status
        }
    }

    return false; // No existing application found
}


    public boolean checkAwaitingPaymentApplication(int studentId) {
    List<FileRecord> records = fileHandler.FetchRecord();

    for (FileRecord record : records) {
        String[] data = record.getRecord().split(";");

        int applicationId = Integer.parseInt(data[0]);
        int studentIdRecord = Integer.parseInt(data[2]);
        String status = data[7];

        if (studentIdRecord == studentId && status.equals("Awaiting Payment")) {
            return true; // Found an application by the student that is Awaiting Payment
        }
    }

    return false; // No Awaiting Payment application found for the student
}


    
    public void checkExpiredApplications() {
        List<FileRecord> records = fileHandler.FetchRecord();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        FileHandler bookedroomfile = new FileHandler(FileName.BOOKED_ROOM);
        
        ApplicationService applicationService = new ApplicationService();
        Application application = applicationService.getApplication(Student_Hostel_System.current_user.getUsername());
        
        
        if (application == null) {
            return; // Return if application is null
        }
            
        RoomService roomservice = new RoomService();
        Room room = roomservice.getRoom(application.getRoomId());
        
        PaymentService paymentservice = new PaymentService();
        ArrayList<Payment> payments = paymentservice.getPayments();

        StudentID = application.getStudentId();
        RoomID = application.getRoomId();
        AppID = application.getApplicationID();
        
        for (Payment payment : payments) {
            if (payment.getApplicationID()==AppID){
                PaymentID = payment.getPaymentID();
            }
        }

        for (FileRecord record : records) {
            String[] data = record.getRecord().split(";");
            String status = data[7];
            String endDateString = data[5];

            if (status.equals("Paid")) {
                try {
                    Date endDate = dateFormat.parse(endDateString);
                    if (currentDate.after(endDate)) {
                        // The current date is after the end date, update the status and availability
                        int applicationID = Integer.parseInt(data[0]);

                        // Update the application status to "Expired"
                        updateApplication(applicationID, "Expired");
                        
                        BookedRoomService bookedRoomService = new BookedRoomService();
                        BookedRoom bookedRoom = new BookedRoom(bookedroomfile.GenerateID(), StudentID, Student_Hostel_System.current_user.getUsername(), AppID, PaymentID, application.getStartDate(), application.getEndDate(), application.getLos(), "Expired", room.getRoomNumber(), room.getRoomType(), room.getFurnish(), "Booked", room.getPrice());
                        bookedRoomService.addBookedRoom(bookedRoom);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

