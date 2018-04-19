package conversion;

import dto.Car;
import generated.CarGenerated;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class DtoToImport {
    public static XMLGregorianCalendar dateConvert(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            try {
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static CarGenerated convert(Car car){
        CarGenerated carGenerated=new CarGenerated();
        carGenerated.setName(car.getName());
        carGenerated.setBrand(car.getBrand());
        carGenerated.setModel(car.getModel());
        carGenerated.setColor(car.getColor());
        carGenerated.setPrice(car.getPrice());
        carGenerated.setState(car.getState());
        carGenerated.setRegistrationDate(dateConvert(car.getRegistrationDate()));
        return carGenerated;
    }
}
