package datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblnutritionalInformation")
public class NutritionalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nutrition_infromation_id")
    long id;

    @Column(name="nutrition")
    private String nutrition;


    @OneToMany(mappedBy = "nutrition")
    private Set<IngredientNutritionalInformation> ingredientsNutritionInformation = new HashSet<>();

    public NutritionalInformation() {
    }

    public NutritionalInformation(String nutrition) {
        this.nutrition = nutrition;
    }

    public long getId() {
        return id;
    }


    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public Set<IngredientNutritionalInformation> getIngredientsNutritionInformation() {
        return ingredientsNutritionInformation;
    }

    public void setIngredientsNutritionInformation(Set<IngredientNutritionalInformation> ingredientsNutritionInformation) {
        this.ingredientsNutritionInformation = ingredientsNutritionInformation;
    }

    @Override
    public final  String toString() {
        return "NutritionalInformation{" +
                "id=" + id +
                ", nutrition='" + nutrition + '\'' +
                ", ingredientsNutritionInformation=" + ingredientsNutritionInformation +
                '}';
    }
}
