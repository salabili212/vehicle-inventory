package com.plurasight;

public class Vehicle {
    long vehicleId;
    String makeModel;
    String color;
    int odometerReading;
    double price;

    Vehicle(){
        System.out.println("###  Welcome ###");
    }


    //All method for the setters.
    public void setVehicleId(long vehicleId){
        this.vehicleId = vehicleId;
    }
    public void setMakeModel(String makeModel){
        this.makeModel = makeModel;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setOdometerReading(int odometerReading){
        this.odometerReading = odometerReading;
    }
    public void setPrice(double price){
        this.price = price;
    }


    //All method for the getter

    public long getVehicleId(){
         return vehicleId;
    }
    public String getMakeModel(){
        return makeModel;
    }
    public String getColor(){
        return color;
    }
    public int getOdometerReading(){
        return odometerReading;
    }
    public double getPrice(){
        return price;
    }
}
