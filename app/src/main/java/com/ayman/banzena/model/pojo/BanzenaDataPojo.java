package com.ayman.banzena.model.pojo;



import java.io.Serializable;

/**
 * Created by ayman on 2019-05-15.
 */

public class BanzenaDataPojo implements Serializable {

    private long id;
    private String banzenaName;
    private String passDate;
    private String passHour;
    private double solar;
    private double oil95;
    private double oil92;
    private double oil80;
    private String tankProblem;
    private String banzenaStatus;
    private String addedProducts;

    private boolean standShow;
    private boolean oilShow;
    private boolean oilTank;
    private boolean oilTawwan;
    private boolean specialProducts;
    private boolean jaraken;
    private boolean specsStandard;
    private String notes;


    public BanzenaDataPojo(long id,String banzenaName, String passDate, String passHour, double solar, double oil95, double oil92,
                           double oil80, String tankProblem, String banzenaStatus, String addedProducts , boolean standShow, boolean oilShow, boolean oilTank, boolean oilTawwan, boolean specialProducts, boolean jaraken, boolean specsStandard, String notes) {
        this.id = id;
        this.banzenaName = banzenaName;
        this.passDate = passDate;
        this.passHour = passHour;
        this.solar = solar;
        this.oil95 = oil95;
        this.oil92 = oil92;
        this.oil80 = oil80;
        this.tankProblem = tankProblem;
        this.banzenaStatus = banzenaStatus;
        this.addedProducts = addedProducts;
        this.standShow = standShow;
        this.oilShow = oilShow;
        this.oilTank = oilTank;
        this.oilTawwan = oilTawwan;
        this.specialProducts = specialProducts;
        this.jaraken = jaraken;
        this.specsStandard = specsStandard;
        this.notes = notes;
    }

    public String getBanzenaName() {
        return banzenaName;
    }

    public String getPassDate() {
        return passDate;
    }

    public String getPassHour() {
        return passHour;
    }

    public double getSolar() {
        return solar;
    }

    public double getOil95() {
        return oil95;
    }

    public double getOil92() {
        return oil92;
    }

    public double getOil80() {
        return oil80;
    }

    public String getTankProblem() {
        return tankProblem;
    }

    public String getBanzenaStatus() {
        return banzenaStatus;
    }

    public boolean isStandShow() {
        return standShow;
    }

    public boolean isOilShow() {
        return oilShow;
    }

    public boolean isOilTank() {
        return oilTank;
    }

    public boolean isOilTawwan() {
        return oilTawwan;
    }

    public boolean isSpecialProducts() {
        return specialProducts;
    }

    public boolean isJaraken() {
        return jaraken;
    }

    public boolean isSpecsStandard() {
        return specsStandard;
    }

    public String getNotes() {
        return notes;
    }
}
