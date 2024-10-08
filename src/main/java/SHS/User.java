/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

import java.util.Arrays;
import main.java.SHS.UI.Admin.UI_Admin_Main;
import javax.swing.JOptionPane;
import main.java.SHS.FileHandlers.FileHandler;
import main.java.SHS.FileHandlers.FileName;
import main.java.SHS.FileHandlers.FileRecord;
import main.java.SHS.UI.UI_Student_Main;
import javax.swing.JOptionPane;
import main.java.SHS.Services.ApplicationService;
import main.java.SHS.UI.UI_Login;

/**
 *
 * @author User
 */
public abstract class User {
    protected int userId;
    protected String username;
    protected String fullname;
    protected String userEmail;
    protected String password;
    protected int age;
    protected Gender gender;
    protected String contact;
    protected UserRole role;

    public User(int userId, String username, String fullname, String userEmail, String password, int age, Gender gender, String contact, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.role = role;
    }
    
    User(int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
    public static boolean login(String username, String password, String fileName) {
        FileHandler fHandler = new FileHandler(fileName);
        FileRecord user_record = fHandler.FetchRecord(username, 1);
        if (user_record == null) {
            JOptionPane.showMessageDialog(null, "Login credential incorrect.", "Oops", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        int user_id = user_record.getID();
        String[] splitted_user_record = user_record.getRecordList();

        if (!(username == null ? splitted_user_record[1] == null : username.equals(splitted_user_record[1]))
                || !(password == null ? splitted_user_record[4] == null : password.equals(splitted_user_record[4]))) {
            JOptionPane.showMessageDialog(null, "Login credential incorrect.", "Oops", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (fileName == null ? FileName.ADMIN == null : fileName.equals(FileName.ADMIN)) {
            Student_Hostel_System.current_user = new Admin(user_id);
        }

        if (fileName == null ? FileName.STUDENT == null : fileName.equals(FileName.STUDENT)) {
            Student_Hostel_System.current_user = new Student(user_id);
        }

        Student_Hostel_System.current_user.setUsername(splitted_user_record[1]);
        Student_Hostel_System.current_user.setAge(Integer.parseInt(splitted_user_record[5]));
        Student_Hostel_System.current_user.setUserEmail(splitted_user_record[3]);
        Student_Hostel_System.current_user.setGender(Gender.valueOf(splitted_user_record[6]));
        Student_Hostel_System.current_user.setPassword(splitted_user_record[4]);
        Student_Hostel_System.current_user.setContact(splitted_user_record[7]);

        switch (fileName) {
            case FileName.ADMIN -> {
                Student_Hostel_System.current_user.setRole(UserRole.ADMIN);
                ApplicationService applicationService = new ApplicationService();
                applicationService.checkExpiredApplications();
                UI_Admin_Main a = new UI_Admin_Main();
                System.out.println("User login successfully");
                JOptionPane.showMessageDialog(null, "Welcome to StudentBNB!", "Successfully Login", JOptionPane.INFORMATION_MESSAGE);
                if (Student_Hostel_System.current_user instanceof Admin) {
                    Admin admin = (Admin) Student_Hostel_System.current_user;
                    admin.logAdminLogin();
                }
                UI_Login l = new UI_Login();
                l.setVisible(false);
                a.setVisible(true);
            }
            case FileName.STUDENT -> {
                Student_Hostel_System.current_user.setRole(UserRole.STUDENT);
                System.out.println("User login successfully");
                JOptionPane.showMessageDialog(null, "Welcome to StudentBNB!", "Successfully Login", JOptionPane.INFORMATION_MESSAGE);
                UI_Login l = new UI_Login();
                l.setVisible(false);
                if (Student_Hostel_System.current_user instanceof Student) {
                    Student student = (Student) Student_Hostel_System.current_user;
                    student.logStudentLogin();
                }
                ApplicationService applicationService = new ApplicationService();
                applicationService.checkExpiredApplications();
                UI_Student_Main s = new UI_Student_Main();
                s.setVisible(true);
            }
            default -> {
                System.out.println("no file name specified.");
            }
        }
    // Call the checkExpiredApplications method
        
        return true;
    }

    
    public static void logout(){
        Student_Hostel_System.current_user = null;
        UI_Login lu = new UI_Login();
        lu.setVisible(true);
    }

}
