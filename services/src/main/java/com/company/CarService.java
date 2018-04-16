package com.company;

import dto.Car;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CarService implements CarServiceInterface {

    @EJB
    private CarRepositoryInterface carRepository;

    public void createCar(Car car) {
        carRepository.setCar(car);
    }

    public List<Car> checkCar() {
        List<Car> temp_car=carRepository.getCar();
        return temp_car;
    }
}
