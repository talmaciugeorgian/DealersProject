package com.company;

import dto.Car;

import java.util.List;

public interface CarServiceInterface {
    public void createCar(Car car);

    public List<Car> checkCar();
    public void importCars();
    public void exportCars();
}
