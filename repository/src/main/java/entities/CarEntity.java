package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
public class CarEntity {

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

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="model")
    private String model;

    @Column(name="mark")
    @Enumerated(EnumType.STRING)
    private Mark mark;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;

    @Column(name = "\"condition\"")
    private Condition condition;

    @Column(name="registration_date")
    private Date registrationDate;

    public CarEntity(String name, String model, Mark mark, String color, int price, Condition condition, Date registrationDate) {
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
