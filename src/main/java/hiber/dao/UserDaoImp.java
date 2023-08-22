package hiber.dao;

import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void getUserByCarModelAndSeries(String model, int series) {
        String hql = "SELECT u FROM User u WHERE u.car.model = :model AND u.car.series = :series";
        User user = sessionFactory
                .getCurrentSession()
                .createQuery(hql, User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
        if (user != null) {
            System.out.printf("ID = %d%nName = %s%nLastName = %s%nEmail = %s%n",
                    user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        } else {
            System.out.printf("Владелец авто: модели = <%s> и выпуска = <%s> - не найден.", model, series);
        }

    }
}
