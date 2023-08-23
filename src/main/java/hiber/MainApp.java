package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Виктор", "Цой",
              "kino@mail.ru",new Car("ВАЗ 2108", 1980)));
      userService.add(new User("Миша", "Горбачев",
              "lastgensek@mail.ru",new Car("Волга", 1995)));
      userService.add(new User("Боря", "Ельцин",
              "bor1991@mail.ru",new Car("Ferrari", 2000)));
      userService.add(new User("Леня", "Брежнев",
              "ussr@mail.ru",new Car("Москвич 412", 1975)));


      List<Car> cars = userService.listCars();
      for (Car car : cars) {
         System.out.printf("Id = %d%nModel = %s%nSeries = %d%n%n",
                 car.getId(), car.getModel(), car.getSeries());
      }

    userService.getUserByCarModelAndSeries("Lada 2108",1980);

      context.close();
   }
}
