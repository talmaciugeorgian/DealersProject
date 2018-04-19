package entities;

import enums.Status;
import generated.Brandgenerated;
import generated.ColorGenerated;
import generated.StateGenerated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@NamedQueries({
        @NamedQuery(name = "CarEntity.getCar", query = "select c from CarEntity c")
})
public class CarEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private Brandgenerated brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private ColorGenerated color;

    @Column(name = "price")
    private int price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateGenerated state;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="posted")
    private Date posted;

    public CarEntity() {
    }

    public CarEntity(String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.state = state;
        this.registrationDate = registrationDate;
    }

    public CarEntity(String name, Brandgenerated brand, String model, ColorGenerated color, int price, StateGenerated state, Date registrationDate, Status status, Date posted) {
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

    public void setState(StateGenerated state) {
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
