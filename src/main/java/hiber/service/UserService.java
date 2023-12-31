package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(Car car);

    List<Car> listCars();

    void add(User user);

    List<User> listUsers();

    void getUserByCarModelAndSeries(String model, int series);
}
