package datasets;

import javax.persistence.*;

@Entity
@Table(name = "tblMeal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meal_id")
    private long id;

    @Column(name="meal")
    private String meal;

    public Meal() {
    }

    public long getId() {
        return id;
    }

    public Meal(String meal) {
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Override
    public final  String toString() {
        return "Meal{" +
                "id=" + id +
                ", meal='" + meal + '\'' +
                '}';
    }
}
