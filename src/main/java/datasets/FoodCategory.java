package datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblFoodCategory")
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="food_category_id")
    private long id;

    @Column(name="food_category")
    private String foodCategory;

    @OneToMany(mappedBy = "foodCategory")
    private Set<RecipeFoodCategory> recipeFoodCategorys = new HashSet<>();


    public FoodCategory() {
    }

    public FoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public void addRecipeFoodCategory(RecipeFoodCategory recipeFoodCategory) {
        this.recipeFoodCategorys.add(recipeFoodCategory);
    }

    public long getId() {
        return id;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Set<RecipeFoodCategory> getRecipeFoodCategory() {
        return recipeFoodCategorys;
    }

    public void setRecipeFoodCategory(Set<RecipeFoodCategory> recipeFoodCategory) {
        this.recipeFoodCategorys = recipeFoodCategory;
    }


}
