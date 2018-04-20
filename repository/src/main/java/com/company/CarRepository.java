package com.company;

import conversion.*;
import dto.Car;
import entities.CarEntity;
import enums.Status;
import generated.Cars;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;


@Stateless
public class CarRepository implements CarRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    //Insert Car into db
    public void setCar(Car car) {
        CarEntity carDto = DtoToEntity.convert(car);
        em.persist(carDto);
        em.flush();
    }

    public List<Car> getCar() {
        List<CarEntity> carEntity =  em.createNamedQuery("CarEntity.getCar", CarEntity.class).getResultList();
        List<Car> car = EntityToDto.convertList(carEntity);
        return car;
    }

    public Cars getExportCars(){
        List<CarEntity> carEntity =  em.createNamedQuery("CarEntity.getCar", CarEntity.class).getResultList();
        Cars cars=EntityToImport.convertList(carEntity);
        return cars;
    }

    public void setCars(Cars cars) {
        List<CarEntity> carsEntity=ImportToEntity.convertList(cars);
        Iterator<CarEntity> entityIterator = carsEntity.iterator();
        while (entityIterator.hasNext()) {
            em.persist(entityIterator.next());
            em.flush();
        }
    }

    public void setInactive() {
        List<CarEntity> carsEntity =  em.createQuery("Select c from CarEntity c where c.status=:status",CarEntity.class).setParameter("status",Status.ACTIVE).getResultList();
        for (CarEntity c: carsEntity) {
            c.setStatus(Status.INACTIVE);
            em.merge(c);
        }
    }

    public void deleteInactive() {
        List<CarEntity> carsEntity=em.createQuery("Select c from CarEntity c where c.status=:status",CarEntity.class).setParameter("status",Status.INACTIVE).getResultList();
        for (CarEntity c: carsEntity) {
            em.remove(c);
        }
    }
}
