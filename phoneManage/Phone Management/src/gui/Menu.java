/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Manager;
import model.Validation;

/**
 *
 * @author Admin
 */
public class Menu {
    
    private static final Manager m = new Manager();
    
    private static final String[] menuOps = {
        "Phones",
        "Tools",
        "Exit program"
    };
    
    private static final String[] phoneOps = {
        "Insert a new phone",
        "Update a phone",
        "Delete a phone",
        "Display all",
        "Exit phones menu"
    };
    
    private static final String[] toolOps = {
        "Filter by manufacturer",
        "Order by release date desc",
        "Filter by price",
        "Order by price desc",
        "Exit tools menu"
    };
    
    public static void displayMenu() {
        int choice;
        do {
            System.out.println("======PHONE MANAGEMENT======");        
            for (int i = 0; i < menuOps.length; i++) 
                System.out.println((i+1) + ". " + menuOps[i]);
            choice = Validation.getInt("Choose: ", 1, menuOps.length);
            
            switch (choice) {
                case 1:
                    displayPhoneOps();
                    break;
                case 2:
                    displayToolOps();
                    break;
                case 3:
                    break;
            }
            System.out.println();
        } while (choice != menuOps.length);
    }
    
    private static void displayPhoneOps() {
        int choice;
        do {
            System.out.println("------Phones Menu------");
            for (int i = 0; i < phoneOps.length; i++)
                System.out.println((i+1) + ". " + phoneOps[i]);
            choice = Validation.getInt("Choose: ", 1, phoneOps.length);
            
            switch (choice) {
                case 1:
                    m.insert();
                    break;
                case 2:
                    m.update();
                    break;
                case 3:
                    m.delete();
                    break;
                case 4:
                    m.displayAll();
                    break;
                case 5:
                    break;
            }
            System.out.println();
        } while (choice != phoneOps.length);
    }
    
    private static void displayToolOps() {
        int choice;
        do {
            System.out.println("------Tools Menu------");
            for (int i = 0; i < toolOps.length; i++)
                System.out.println((i+1) + ". " + toolOps[i]);
            choice = Validation.getInt("Choose: ", 1, toolOps.length);
            
            switch (choice) {
                case 1:
                    m.filterByManufact();
                    break;
                case 2:
                    m.orderByReleaseDate();
                    break;
                case 3:
                    m.filterByPrice();
                    break;
                case 4:
                    m.orderByPrice();
                    break;
                case 5:
                    break;
            }
            System.out.println();
        } while (choice != toolOps.length);
    }
    
}
