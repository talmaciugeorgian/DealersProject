package conversion;

import dto.Car;
import generated.CarGenerated;
import generated.Cars;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImportToDto {
    //date conversion
    public static java.util.Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }
    //Imported class -> Car.dto
    public static Car convertImportToCar(CarGenerated car){
        return new Car(car.getName(),car.getBrand(),car.getModel(),car.getColor(),car.getPrice(),car.getState(),asDate(car.getRegistrationDate()),new Date());
    }

    public static List<Car> convertList(Cars cars){
        List<Car> carList = new ArrayList<Car>();
        List<CarGenerated> temp_generatedCar = cars.getCar();
        Iterator<CarGenerated> it = temp_generatedCar.iterator();
        while (it.hasNext()) {
            carList.add(ImportToDto.convertImportToCar(it.next()));
        }
        return carList;
    }
}
