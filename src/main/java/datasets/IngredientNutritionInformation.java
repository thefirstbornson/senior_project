package datasets;

import javax.persistence.*;

@Entity
@Table(name = "tblIngredientNutritionanInformation")
public class IngredientNutritionInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rni_id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ni_id")
    private NutritionInformation nutrition;

    @Column(name="amount")
    private int amount;

    public IngredientNutritionInformation() {
    }

    public long getId() {
        return id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public NutritionInformation getNutritionanInformation() {
        return nutrition;
    }

    public void setNutritionanInformation(NutritionInformation nutritionanInformation) {
        this.nutrition = nutritionanInformation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
