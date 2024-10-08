/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.SHS.FileHandlers;

/**
 *
 * @author User
 */
public class FileRecord {
    private int id;
    private String record;

    public FileRecord(int id, String data) {
        this.id = id;
        this.record = data;
    }

    public int getID() {
        return id;
    }

    public String getRecord() {
        return record;
    }
    
    public String[] getRecordList(){
        return record.split(";");
    }

    @Override
    public String toString() {
        return "FileRecord{" + "id=" + id + ", record=" + record + '}';
    }
    
    
}

