package com.company;

import dto.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarRepositoryInterface {
    public void setCar(Car car);

    public List<Car> getCar();
}
