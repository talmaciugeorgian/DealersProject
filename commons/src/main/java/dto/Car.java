package dto;

import javax.persistence.*;
import java.util.Date;

public class Car {

    public enum Mark{
        SEDAN,
        ALLWHEELDRIVE,
        PICKUP,
        CONVERTABLE
    }

    public enum Condition{
        NEW,
        USED
    }

    private int id;
    private String name;
    private String model;
    private Mark mark;
    private String color;
    private int price;
    private Condition condition;
    private Date registrationDate;

    public Car(String name, String model, Mark mark, String color, int price, Condition condition, Date registrationDate) {
        this.name = name;
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.price = price;
        this.condition = condition;
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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

