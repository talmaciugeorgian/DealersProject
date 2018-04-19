package conversion;

import dto.Car;
import generated.CarGenerated;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
