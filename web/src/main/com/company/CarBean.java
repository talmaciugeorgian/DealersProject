package com.company;

import dto.Car;
import generated.Brandgenerated;
import generated.ColorGenerated;
import generated.StateGenerated;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
    private Brandgenerated brand;
    private ColorGenerated color;
    private int price;
    private StateGenerated state;
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

    public void importData() {

        carService.importCars();
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
