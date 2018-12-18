package datasets;

import javax.persistence.*;

@Entity
@Table(name = "tblIngredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    long id;

    @Column(name="name")
    private String name;

    @Column(name="calories_per_100g")
    private int calrsPer100;

    public Ingredient(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalrsPer100() {
        return calrsPer100;
    }

    public void setCalrsPer100(int calrsPer100) {
        this.calrsPer100 = calrsPer100;
    }

    public Ingredient(String name, int calrsPer100) {
        this.name = name;
        this.calrsPer100 = calrsPer100;
    }
}
