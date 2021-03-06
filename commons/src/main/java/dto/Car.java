package dto;



import enums.Status;
import generated.Brandgenerated;
import generated.ColorGenerated;
import generated.StateGenerated;

import java.util.Date;

public class Car {
    private int id;
    private String name;
    private Brandgenerated brand;
    private String model;
    private ColorGenerated color;
    private int price;
    private StateGenerated state;
    private Date registrationDate;
    private Status status;
    private Date posted;

    public Car(int id, String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
    }

    public Car(String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
    }

    public Car(String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate, Date posted) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
        this.posted = posted;
    }

    public Car(String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate, Status status, Date posted) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
        this.status = status;
        this.posted = posted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brandgenerated getBrand() {
        return brand;
    }

    public void setBrand(Brandgenerated brand) {
        this.brand = brand;
    }

    public ColorGenerated getColor() {
        return color;
    }

    public void setColor(ColorGenerated color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public StateGenerated getState() {
        return state;
    }

    public void setCondition(StateGenerated state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }
}

