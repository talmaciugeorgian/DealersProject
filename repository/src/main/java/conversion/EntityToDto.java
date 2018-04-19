package conversion;

import dto.Car;
import entities.CarEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EntityToDto {
    //CarEntity ->Car.dto
    public static Car convert(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getBrand(), carEntity.getModel(), carEntity.getColor(), carEntity.getPrice(), carEntity.getState(), carEntity.getRegistrationDate(),new Date());
    }

    //<list>CarEntity -> <list>Car
    public static List<Car> convertList(List<CarEntity> carEntity) {
        List<Car> car = new ArrayList<Car>();
        Iterator<CarEntity> it = carEntity.iterator();
        while (it.hasNext()) {
            car.add(convert(it.next()));
        }
        return car;
    }
}
