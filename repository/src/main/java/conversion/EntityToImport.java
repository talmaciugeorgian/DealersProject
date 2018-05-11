package conversion;

import dto.Car;
import entities.CarEntity;
import generated.CarGenerated;
import generated.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityToImport {
    public static Cars convertList(List<CarEntity> carsEntity){
        List<Car> carList = EntityToDto.convertList(carsEntity);
        Cars cars=new Cars();
        List<CarGenerated> carGenerated=new ArrayList<CarGenerated>();
        Iterator<Car> carIterator=carList.iterator();
        while (carIterator.hasNext()) {
            carGenerated.add(DtoToImport.convert(carIterator.next()));
        }

        Iterator<CarGenerated> carGeneratedIterator=carGenerated.iterator();
        while(carGeneratedIterator.hasNext()){
            cars.getCar().add(carGeneratedIterator.next());
        }
        return cars;
    }
}
