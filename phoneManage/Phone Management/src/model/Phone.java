package model;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Phone {
    private String IMEI;
    private String name;
    private String manufact;
    private double price;
    private Date release;
    private int RAM;
    private int ROM;
    private String chip;
    private double screenSize;
    private String phoneSize;

    public Phone() {
    }

    public Phone(String IMEI, String name, String manufact, double price, Date release, int RAM, int ROM, String chip, double screenSize, String phoneSize) {
        this.IMEI = IMEI;
        this.name = name;
        this.manufact = manufact;
        this.price = price;
        this.release = release;
        this.RAM = RAM;
        this.ROM = ROM;
        this.chip = chip;
        this.screenSize = screenSize;
        this.phoneSize = phoneSize;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getPhoneSize() {
        return phoneSize;
    }

    public void setPhoneSize(String phoneSize) {
        this.phoneSize = phoneSize;
    }

    @Override
    public String toString() {
        return IMEI + ", " + name + ", " + manufact 
                + ", " + price + ", " + Validation.dateToString(release)
                + ", " + RAM + ", " + ROM + ", " + chip 
                + ", " + screenSize + ", " + phoneSize;
    }
    
}
