package conversion;

import dto.Car;
import entities.CarEntity;
import generated.Cars;

import java.util.ArrayList;
import java.util.List;

public class ImportToEntity {
    public static List<CarEntity> convertList(Cars cars){
        List<Car> carList=ImportToDto.convertList(cars);
        List<CarEntity> carEntities=DtoToEntity.convertList(carList);
        return carEntities;
    }
}
