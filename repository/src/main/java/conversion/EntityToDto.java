package conversion;

import dto.Car;
import dto.User;
import entities.CarEntity;
import entities.UsersEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EntityToDto {
    public static User convert(UsersEntity usersEntity) {
        return new User(usersEntity.getUsername(), usersEntity.getPassword(),usersEntity.getUserType());
    }
    public static List<User> convertUsersList(List<UsersEntity> usersEntity){
        List<User> users = new ArrayList<User>();
        Iterator<UsersEntity> it = usersEntity.iterator();
        while (it.hasNext()) {
            users.add(convert(it.next()));
        }
        return users;
    }

    //CarEntity ->Car.dto
    public static Car convert(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getBrand(), carEntity.getModel(), carEntity.getColor(), carEntity.getPrice(), carEntity.getState(), carEntity.getRegistrationDate(),new Date());
    }

    //<list>CarEntity -> <list>Car
    public static List<Car> convertList(List<CarEntity> carsEntity) {
        List<Car> cars = new ArrayList<Car>();
        Iterator<CarEntity> it = carsEntity.iterator();
        while (it.hasNext()) {
            cars.add(convert(it.next()));
        }
        return cars;
    }
}
