package hiber.service;

import hiber.dao.CarDaoHibernet;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private CarDaoHibernet carDaoHibernet;

   private UserDao userDao;

   UserServiceImp (UserDao userDao,CarDaoHibernet carDaoHibernet){
      this.userDao=userDao;
      this.carDaoHibernet = carDaoHibernet;
   }

   @Transactional
   @Override
   public void add(Car car) {
      carDaoHibernet.add(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return carDaoHibernet.listCars();
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public void getUserByCarModelAndSeries(String model, int series) {
      userDao.getUserByCarModelAndSeries(model, series);
   }
}
