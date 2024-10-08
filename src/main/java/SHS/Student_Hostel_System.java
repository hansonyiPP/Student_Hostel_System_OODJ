/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.java.SHS;

import main.java.SHS.UI.*;

/**
 *
 * @author User
 */
public class Student_Hostel_System {
    public static User current_user;
    public static boolean isLogIn;
    
    private void initialize(){
        UI_Login lu = new UI_Login();
        lu.setVisible(true);
       

    }
    
    public static void main(String[] args) {
        Student_Hostel_System main = new Student_Hostel_System();
        main.initialize();
    }
}
