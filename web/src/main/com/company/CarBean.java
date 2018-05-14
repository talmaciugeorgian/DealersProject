package com.company;

import dto.Car;
import enums.Brand;
import enums.Color;
import enums.State;
import generated.Brandgenerated;
import generated.ColorGenerated;
import generated.StateGenerated;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

@ManagedBean(name = "carBean", eager = true)
@SessionScoped
public class CarBean implements Serializable {
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

    private List<Brand> brands=new ArrayList<>(EnumSet.allOf(Brand.class));
    private List<Color> colors=new ArrayList<>(EnumSet.allOf(Color.class));
    private List<State> states=new ArrayList<>(EnumSet.allOf(State.class));

    private boolean hideTable=false;
    private List<Car> filteredCars;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean login;

    @EJB
    private CarServiceInterface carService;


    public String addCar() {
        car = new Car(name, brand, model, color, price, state, registrationDate,new Date());
        carService.createCar(car);
        return "carRedirectPage";
    }

    public void getCarListings() {
        carList = new ArrayList<Car>();
        carList = carService.checkCar();
        hideTable=true;
    }

    public void importData() {
        carService.importCars();
    }

    public void exportData(){
        carService.exportCars();
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

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    public List<Car> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Car> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public boolean isHideTable() {
        return hideTable;
    }

    public void setHideTable(boolean hideTable) {
        this.hideTable = hideTable;
    }
}
