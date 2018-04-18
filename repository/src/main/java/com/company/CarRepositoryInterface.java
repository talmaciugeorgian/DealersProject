package com.company;

import dto.Car;
import generated.CarGenerated;
import generated.Cars;

import java.util.List;

public interface CarRepositoryInterface {
    public void setCar(Car car);
    public List<Car> getCar();
    public void setCars(Cars cars);
    public void setInactive();
}
