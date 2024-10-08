package main.java.SHS.Services;

import main.java.SHS.FileHandlers.FileHandler;
import main.java.SHS.FileHandlers.FileName;
import main.java.SHS.FileHandlers.FileRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class LogService {
    private static final String LOG_FILE = FileName.LOGS;
    private static LogService instance;

    private LogService() {
    }

    public static LogService getInstance() {
        if (instance == null) {
            instance = new LogService();
        }
        return instance;
    }

    public void log(String message) {
        FileHandler fileHandler = new FileHandler(LOG_FILE);
        String logEntry = fileHandler.GenerateID()+ ";" + getCurrentDate() + ";" + getCurrentTime() + ";" + message;
        fileHandler.InsertRecord(new FileRecord(fileHandler.GenerateID(), logEntry));
    }
    
    public List<String> getRecordsByUsername(String username) {
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\SHS\\Txtfiles\\logs.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[5].equals(username)) {
                    records.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort records in descending order
        Collections.sort(records, Comparator.reverseOrder());

        return records;
    }

    private String getCurrentDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(now);
    }
    
    private String getCurrentTime() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(now);
    }
    
    
}
