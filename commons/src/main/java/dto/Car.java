package dto;

import javax.persistence.*;
import java.util.Date;

public class Car {

    public enum Brand{
        BMW,
        SKODA,
        KIA,
        AUDI,
        JAGUAR,
        PORCHE,
        FORD,
        VW
    }

    public enum State{
        NEW,
        USED
    }

    public enum Color{
        RED,
        BLACK,
        BLUE,
        YELLOW,
        WHITE,
        GREEN
    }

    private int id;
    private String name;
    private Brand brand;
    private String model;
    private Color color;
    private int price;
    private State state;
    private Date registrationDate;

    public Car(String name, Brand brand,String model, Color color, int price, State state, Date registrationDate) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public State getState() {
        return state;
    }

    public void setCondition(State state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

