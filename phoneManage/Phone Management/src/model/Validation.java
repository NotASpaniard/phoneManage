/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    private static final String DATE_FORMAT = "dd-MM-yyyy";        
    
    public static int getInt(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) return n;
                System.err.println("PLEASE ENTER A NUMBER IN RANGE: " + min + " -> " + max);
            } catch (NumberFormatException ex) {
                System.err.println("WRONG FORMAT!!");
            }
        }
    }
    
    public static double getDouble(String msg, double min, double max) {
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }
        
        while (true) {
            try {
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if (min <= n && n <= max) return n;
                System.err.println("PLEASE ENTER A NUMBER IN RANGE: " + min + " -> " + max);
            } catch (NumberFormatException ex) {
                System.err.println("WRONG FORMAT!!");
            }
        }
    }
    
    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) return s;
            System.err.println("PLEASE ENTER A NON-EMPTY STRING!!");
        }
    }
    
    public static String getStringMatchesRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.matches(regex)) return s;
            System.err.println(err);
        }
    }
    
    public static String getIMEI(String msg, Manager m) {
        while (true) {
            System.out.print(msg);
            String IMEI = sc.nextLine();
            if (!IMEI.isEmpty() && m.searchPhone(IMEI) == null) return IMEI;
            System.err.println("IMEI MUST BE UNIQUE AND NOT EMPTY!!");
        }
    }
    
    public static Date getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(msg);
                String date = sc.nextLine();
                return sdf.parse(date);                
            } catch (ParseException ex) {
                System.err.println("INVALID DATE!! MUST HAVE FORMAT " + DATE_FORMAT);
            }
        }
    }
    
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
    
}