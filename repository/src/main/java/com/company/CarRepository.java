package com.company;

import dto.Car;
import entities.CarEntity;
import generated.CarGenerated;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Stateless
public class CarRepository implements CarRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public java.util.Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public Car convertImportToCar(CarGenerated car){
        return new Car(car.getId(),car.getName(),car.getBrand(),car.getModel(),car.getColor(),car.getPrice(),car.getState(),asDate(car.getRegistrationDate()));
    }

    public CarEntity convert(Car car) {
        return new CarEntity(car.getName(), car.getBrand(), car.getModel(), car.getColor(), car.getPrice(), car.getState(), car.getRegistrationDate());
    }
    public CarEntity converT(Car car) {
        return new CarEntity(car.getId(),car.getName(), car.getBrand(), car.getModel(), car.getColor(), car.getPrice(), car.getState(), car.getRegistrationDate());
    }

    public Car converttoCar(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getBrand(), carEntity.getModel(), carEntity.getColor(), carEntity.getPrice(), carEntity.getState(), carEntity.getRegistrationDate());
    }
    public Car convertToCar(CarEntity carEntity) {
        return new Car(carEntity.getId(),carEntity.getName(), carEntity.getBrand(), carEntity.getModel(), carEntity.getColor(), carEntity.getPrice(), carEntity.getState(), carEntity.getRegistrationDate());
    }


    public List<Car> convertDtoToCar(List<CarEntity> carEntity) {
        List<Car> car = new ArrayList<Car>();
        Iterator<CarEntity> it = carEntity.iterator();
        while (it.hasNext()) {
            car.add(convertToCar(it.next()));
        }
        return car;
    }

    public void setCar(Car car) {
        CarEntity carDto = convert(car);
        em.persist(carDto);
        em.flush();
    }

    public List<Car> getCar() {
        List<CarEntity> carEntity = (List<CarEntity>) em.createNamedQuery("CarEntity.getCar", CarEntity.class).getResultList();
        List<Car> car = convertDtoToCar(carEntity);
        return car;
    }

    public void setCars(List<Car> cars){
        List<CarEntity> carsEntity = new ArrayList<CarEntity>();
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            carsEntity.add(converT(it.next()));
        }
        Iterator<CarEntity> entityIterator=carsEntity.iterator();
        while(entityIterator.hasNext()){
            em.persist(entityIterator.next());
            em.flush();
        }
    }
}
