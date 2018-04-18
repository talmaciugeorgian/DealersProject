package com.company;

import conversion.DtoToEntity;
import conversion.EntityToDto;
import conversion.ImportToDto;
import dto.Car;
import entities.CarEntity;
import enums.Status;
import generated.CarGenerated;
import generated.Cars;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static conversion.DtoToEntity.*;

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

    public void setCars(Cars cars) {
        List<Car> car = new ArrayList<Car>();
        List<CarGenerated> temp_generatedCar = cars.getCar();
        Iterator<CarGenerated> it = temp_generatedCar.iterator();
        while (it.hasNext()) {
            car.add(ImportToDto.convertImportToCar(it.next()));
        }

        List<CarEntity> carsEntity = new ArrayList<CarEntity>();
        Iterator<Car> carIterator = car.iterator();
        while (carIterator.hasNext()) {
            carsEntity.add(DtoToEntity.convert(carIterator.next()));
        }

        Iterator<CarEntity> entityIterator = carsEntity.iterator();
        while (entityIterator.hasNext()) {
            em.persist(entityIterator.next());
            em.flush();
        }
    }

    public void setInactive() {
        List<CarEntity> carsEntity =  em.createQuery("Select c from CarEntity c where c.status=:status",CarEntity.class).setParameter("status",Status.ACTIVE).getResultList();
//        Iterator<CarEntity> entityIterator = carsEntity.iterator();
//        while (entityIterator.hasNext()) {
//            entityIterator.next().setStatus(Status.INACTIVE);
//            em.merge(entityIterator.);
//        }
        for (CarEntity c: carsEntity) {
            c.setStatus(Status.INACTIVE);
            em.merge(c);
        }
    }
}
