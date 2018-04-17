package com.company;

import dto.Car;
import generated.CarGenerated;

import java.util.ArrayList;
import java.util.List;

public interface CarRepositoryInterface {
    public void setCar(Car car);

    public List<Car> getCar();

    public Car convertImportToCar(CarGenerated car);
    public void setCars(List<Car> cars);
}
