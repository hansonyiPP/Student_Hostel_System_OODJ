/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS.Services;

import main.java.SHS.FileHandlers.*;
import main.java.SHS.Gender;
import main.java.SHS.Student;
import main.java.SHS.UserRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ethan
 */
public class StudentService {
    private static StudentService student_service;
    
     public static StudentService getStudentService()
    {
        //Not instantiated yet
        if (student_service == null)
        {
            student_service = new StudentService();
        }
        return student_service;
    }
     
      public static void offStudentService(){
         StudentService.student_service = null;
     }
     
    private ArrayList<Student> students;
    FileHandler student_file = new FileHandler(FileName.STUDENT);
    
    public StudentService(){
         this.students = new ArrayList<Student>();
            
           List<FileRecord> student_records = student_file.FetchRecord();
           student_records.forEach((record) -> {
               Student student_object = convertToObject(record);
               this.students.add(student_object);
           });
           System.out.println(students);
           this.students.forEach((record) -> System.out.println(record.getUsername())
           );
    }
    
    private Student convertToObject(FileRecord s){
        String[] student_data = s.getRecordList();
        if(student_data.length == 0){
            return null;
        }
        int student_id = s.getID();
        String student_name = student_data[1];
        String student_fullname = student_data[2];
        String student_email = student_data[3];
        String student_password = student_data[4];
        int student_age = Integer.parseInt(student_data[5]);
        Gender student_gender = Gender.valueOf(student_data[6]);
        String student_phone = student_data[7];

        // Still missing NULL Value for card 
        return new Student(student_id, student_name, student_fullname, student_email, student_password, student_age, student_gender, student_phone, UserRole.STUDENT);

    }
    
    private FileRecord convertToFileRecord(Student student){
         String student_record_string = student.getUserId() + ";" + student.getUsername()+ ";" + student.getFullname()+ ";" + student.getUserEmail() + ";" + student.getPassword()+ ";" + student.getAge() + ";" +student.getGender() + ";" + student.getContact();
         return new FileRecord(student.getUserId(), student_record_string);
    }
    
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
    public Student getStudent(int id){
        Student response = null;
        for(int i = 0; i < students.size(); i ++) {
            if(students.get(i).getUserId()== id){
                response = students.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"students\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
    
    public ArrayList<String> getStudentEmails(){
        ArrayList<String> student_emails = new ArrayList<String>();
         for(Student m : students){
             student_emails.add(m.getUserEmail());
         }
         return student_emails;
    }
    
    public void addStudent(Student student){
        this.students.add(student);
        FileRecord student_record = convertToFileRecord(student);
        student_file.InsertRecord(student_record);
    }
    
    public void updateStudent(Student student){
        for(int i=0; i < students.size(); i++){
            if(students.get(i).getUserId()== student.getUserId()){
                students.set(i, student);
                FileRecord student_record = convertToFileRecord(student);
                student_file.UpdateRecord(student_record);
                break;
            }
        }
    }
    
    public void deleteStudent(Student student) {
         for(int i=0; i < students.size(); i++){
            if(students.get(i).getUserId()== student.getUserId()){
                // Remove from student object
                students.remove(students.get(i));
                // Remove from Student Text file
                FileRecord student_record = convertToFileRecord(student);
                student_file.DeleteRecord(student_record);
                break;
            }
        }
    }
}
