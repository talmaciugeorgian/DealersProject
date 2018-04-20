package conversion;

import dto.Address;
import dto.Car;
import dto.User;
import entities.AddressEntity;
import entities.CarEntity;
import entities.UsersEntity;
import enums.AccountType;
import enums.Status;
import enums.UserType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DtoToEntity {
    public static AddressEntity convertAddr(Address address) {
        return new AddressEntity(address.getStreet(), address.getPostalCode(), address.getCity(), address.getPhone());
    }

    public static UsersEntity convert(User user) {
        AddressEntity temp_address = convertAddr(user.getAddress());
        return new UsersEntity(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(),UserType.USER,AccountType.INACTIVE, temp_address);
    }

    //Car.dto ->CarEntity
    public static CarEntity convert(Car car) {
        return new CarEntity(car.getName(), car.getBrand(), car.getModel(), car.getColor(), car.getPrice(), car.getState(), car.getRegistrationDate(),Status.ACTIVE,new Date());
    }

    public static List<CarEntity> convertList(List<Car> cars){
        List<CarEntity> carsEntity = new ArrayList<CarEntity>();
        Iterator<Car> carIterator = cars.iterator();
        while (carIterator.hasNext()) {
            carsEntity.add(DtoToEntity.convert(carIterator.next()));
        }
        return carsEntity;
    }
}
