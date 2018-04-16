package com.company;

import dto.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarServiceInterface {
    public void createCar(Car car);

    public List<Car> checkCar();
}
