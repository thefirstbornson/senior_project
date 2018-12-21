package datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblMeal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meal_id")
    private long id;

    @Column(name="meal")
    private String meal;

    //@OneToMany(mappedBy = "meal")
   //private Set<RecipeMeal> recipeMeals = new HashSet<>();

    public Meal() {
    }

    public long getId() {
        return id;
    }

    public Meal(String meal) {
        this.meal = meal;
    }

//    public void addRecipeMeal(RecipeMeal recipeMeal) {
//        this.recipeMeals.add(recipeMeal);
//    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

//    public Set<RecipeMeal> getRecipeMeals() {
//        return recipeMeals;
//    }
//
//    public void setRecipeMeals(Set<RecipeMeal> recipeMeals) {
//        this.recipeMeals = recipeMeals;
//    }
}
