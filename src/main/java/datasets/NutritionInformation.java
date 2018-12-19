package datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblNutritionInformation")
public class NutritionInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nutrition_infromation_id")
    long id;

    @Column(name="nutrition")
    private String nutrition;


    @OneToMany(mappedBy = "nutrition")
    private Set<IngredientNutritionInformation> ingredientsNutritionInformation = new HashSet<>();

    public NutritionInformation() {
    }

    public NutritionInformation(String nutrition) {
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

    public Set<IngredientNutritionInformation> getIngredientsNutritionInformation() {
        return ingredientsNutritionInformation;
    }

    public void setIngredientsNutritionInformation(Set<IngredientNutritionInformation> ingredientsNutritionInformation) {
        this.ingredientsNutritionInformation = ingredientsNutritionInformation;
    }
}
