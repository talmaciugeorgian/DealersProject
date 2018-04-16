package com.company;

import dto.Car;
import enums.Brand;
import enums.Color;
import enums.State;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "carBean", eager = true)
@SessionScoped
public class CarBean {
    private int id;
    private String name;
    private String model;
    private Brand brand;
    private Color color;
    private int price;
    private State state;
    private Date registrationDate;
    private Car car;
    private List<Car> carList;

    @EJB
    private CarServiceInterface carService;


    public String addCar() {
        car = new Car(name, brand, model, color, price, state, registrationDate);
        carService.createCar(car);
        return "carRedirectPage";
    }

    public String getCarListings() {
        carList = new ArrayList<Car>();
        carList = carService.checkCar();
        return "carListings";
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

    public void setState(State state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarServiceInterface getCarService() {
        return carService;
    }

    public void setCarService(CarServiceInterface carService) {
        this.carService = carService;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
