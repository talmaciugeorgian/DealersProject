package conversion;

import dto.Car;
import entities.CarEntity;
import enums.Status;

import java.util.Date;

public class DtoToEntity {
    //Car.dto ->CarEntity
    public static CarEntity convert(Car car) {
        return new CarEntity(car.getName(), car.getBrand(), car.getModel(), car.getColor(), car.getPrice(), car.getState(), car.getRegistrationDate(),Status.ACTIVE,new Date());
    }
}
