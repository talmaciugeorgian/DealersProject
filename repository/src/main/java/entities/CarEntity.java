package entities;

import dto.Car;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@NamedQueries({
        @NamedQuery(name="CarEntity.getCar",query="select c from CarEntity c")
})
public class CarEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    @Enumerated(EnumType.STRING)
    private Car.Brand brand;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Car.Color color;

    @Column(name = "price")
    private int price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private Car.State state;

    @Column(name="registration_date")
    private Date registrationDate;

    public CarEntity() {
    }

    public CarEntity(String name, Car.Brand brand, String model, Car.Color color, int price, Car.State state, Date registrationDate) {
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

    public Car.Brand getBrand() {
        return brand;
    }

    public void setBrand(Car.Brand brand) {
        this.brand = brand;
    }

    public Car.Color getColor() {
        return color;
    }

    public void setColor(Car.Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car.State getState() {
        return state;
    }

    public void setState(Car.State state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
