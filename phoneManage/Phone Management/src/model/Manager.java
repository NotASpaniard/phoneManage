/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Manager {
    private List<Phone> pList;

    public Manager() {
        pList = new ArrayList<>();
    }
       
    public void insert() {
        String IMEI = Validation.getIMEI("Enter IMEI: ", this);
        String name = Validation.getString("Enter phone name: ");
        String manufact = Validation.getString("Enter manufacturer: ");
        double price = Validation.getDouble("Enter price($): ", 1, Double.MAX_VALUE);
        Date date = Validation.getDate("Enter release date: ");
        int RAM = Validation.getInt("Enter RAM(GB): ", 2, 32);
        int ROM = Validation.getInt("Enter ROM(MB): ", 4, 8);
        String chip = Validation.getString("Enter phone chip: ");
        double screenSize = Validation.getDouble("Enter screen size(inch): ", 4, 7);
        String phoneSize = Validation.getStringMatchesRegex("Enter phone size (length x width x thickness): "
                , "^\\d{1,2}x\\d{1,2}x\\d{1,2}$", "WRONG FORMAT!! (EXAMPLE: 11x22x33) at most 2 digits");
        
        pList.add(new Phone(IMEI, name, manufact, price, date, RAM, ROM, chip, screenSize, phoneSize));
        System.out.println(pList);
        System.out.println("Add successful.");
    }
    
    public void update() {
        String IMEI = Validation.getString("Enter IMEI to update: ");
        Phone p = searchPhone(IMEI);
        if (p == null)
            System.err.println("NOT FOUND!!");
        else {
            p.setName(Validation.getString("Enter new phone name: "));
            p.setManufact(Validation.getString("Enter new manufacturer: "));
            p.setPrice(Validation.getDouble("Enter new price($): ", 1, Double.MAX_VALUE));
            p.setRelease(Validation.getDate("Enter new release date: "));
            p.setRAM(Validation.getInt("Enter new RAM(GB): ", 2, 32));
            p.setROM(Validation.getInt("Enter new ROM(MB): ", 4, 8));
            p.setChip(Validation.getString("Enter new phone chip: "));
            p.setScreenSize(Validation.getDouble("Enter new screen size(inch): ", 4, 7));
            p.setPhoneSize(Validation.getStringMatchesRegex("Enter new phone size (length x width x thickness): "
                , "^\\d{1,2}x\\d{1,2}x\\d{1,2}$", "WRONG FORMAT!! (EXAMPLE: 11x22x33) at most 2 digits"));
            System.out.println("Update successful.");
        }
    }
    
    public void delete() {
        String IMEI = Validation.getString("Enter IMEI to delete: ");
        Phone p = searchPhone(IMEI);
        if (p == null)
            System.err.println("NOT FOUND!!");
        else {
            pList.remove(p);
            System.out.println("DELETE SUCCESSFUL");
        }
    }
    
    public void displayAll() {
        pList.forEach((p) -> {
            System.out.println(p);
        });
    }
    
    protected Phone searchPhone(String IMEI) {
        for (Phone p : pList)
            if (p.getIMEI().equalsIgnoreCase(IMEI))
                return p;
        return null;
    }
    
    public void filterByManufact() {
        String manufact = Validation.getString("Enter manufacturer to filter: ");
        boolean found = false;
        for (Phone p : pList) {
            if (p.getManufact().equalsIgnoreCase(manufact)) {
                found = true;
                System.out.println(p);
            }
        }
        
        if (!found)
            System.err.println("Manufacturer " + manufact + " not found!!");
    }
    
    public void filterByPrice() {
        double min = Validation.getDouble("Enter min value: ", 1, Double.MAX_VALUE);
        double max = Validation.getDouble("Enter max value: ", 1, Double.MAX_VALUE);
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }
        
        boolean found = false;
        for (Phone p : pList)
            if (min <= p.getPrice() && p.getPrice() <= max) {
                found = true;           
                System.out.println(p);
            }
        
        if (!found)
            System.err.println("No phone have value from " + min + " to " + max);
    }
    
    public void orderByReleaseDate() {
        Collections.sort(pList, (Phone o1, Phone o2) -> {
            if (o1.getRelease().before(o2.getRelease()))
                return 1;
            return -1;
        });
        
        displayAll();
    }
    
    public void orderByPrice() {
        Collections.sort(pList, (Phone o1, Phone o2) -> {
            if (o1.getPrice() < o2.getPrice())
                return 1;
            return -1;
        });
        
        displayAll();
    }    
    
}
