package com.company;

import generated.CarGenerated;
import generated.Cars;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBNnmarshal {
    public static Cars importCars() {
        try{
            File file=new File("C:\\dev\\workspace\\dealer_project\\commons\\src\\main\\resources\\schemas\\cars.xml");
            JAXBContext jaxbContext=JAXBContext.newInstance(Cars.class);

            Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
            Cars cars= (Cars) jaxbUnmarshaller.unmarshal(file);
            return cars;

        }catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        importCars();
    }
}
