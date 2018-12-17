package datasets;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    long id;

    @Column(name="name")
    private String name;

    @Column(name="calories_per_100g")
    private int calrsPer100;
}
