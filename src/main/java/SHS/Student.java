/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS;

import main.java.SHS.Services.LogService;
import main.java.SHS.User;

/**
 *
 * @author User
 */
public class Student extends User{

    
    public Student(int userId, String username, String fullname, String userEmail, String password, int age, Gender gender, String contact, UserRole role) {
        super(userId, username, fullname, userEmail, password, age, gender, contact, role);
    }

    public Student(int user_id) {
        super(user_id);
    }
    
        public void logStudentLogin() {
    LogService logService = LogService.getInstance();
    logService.log("Student" + ";" + getUserId()+ ";" + getUsername());
}

}