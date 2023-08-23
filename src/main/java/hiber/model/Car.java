package hiber.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    public Car() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;
    private String model;

    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getSeries() == car.getSeries() && Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSeries());
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getModel() {return model;}

    public void setModel(String model) { this.model = model;}

    public int getSeries() {return series;    }

    public void setSeries(int series) {this.series = series;    }

    public User getUser() {return user;    }

    public void setUser(User user) { this.user = user;    }

}
