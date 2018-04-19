package com.company;

import dto.Car;
import generated.CarGenerated;
import generated.Cars;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Stateless
public class CarService implements CarServiceInterface {

    @EJB
    private CarRepositoryInterface carRepository;

    public void createCar(Car car) {
        carRepository.setCar(car);
    }

    public List<Car> checkCar() {
        List<Car> temp_car = carRepository.getCar();
        return temp_car;
    }

    public void importCars(){
        carRepository.setInactive();
        try {
            carRepository.setCars(UnmarshalCars());
            carRepository.deleteInactive();
        }catch (Exception ex){
            ex.printStackTrace();
            //carRepository.setActive();
        }
    }

    public Cars UnmarshalCars() {
        try {
            File file = new File("C:\\dev\\workspace\\dealer_project\\commons\\src\\main\\resources\\pdi\\exportedXML\\exportedCars.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cars cars = (Cars) jaxbUnmarshaller.unmarshal(file);
            return cars;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void exportCars(){
        Cars exportCars=carRepository.getExportCars();
        try{
            File file=new File("C:\\dev\\workspace\\dealer_project\\commons\\src\\main\\resources\\pdi\\exportedXML\\exportedCars.xml");
            JAXBContext jaxbContext=JAXBContext.newInstance(Cars.class);
            Marshaller jaxbMarshaller=jaxbContext.createMarshaller();

            jaxbMarshaller.marshal(exportCars,file);

        }catch(JAXBException e){
            e.printStackTrace();
        }
    }

}
