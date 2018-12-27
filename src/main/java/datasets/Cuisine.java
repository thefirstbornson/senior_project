package datasets;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tblCuisine")
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cuisine_id")
    private long id;

    @Column(name="cuisine")
    private String cuisine;

    @OneToMany(mappedBy = "cousine", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Recipe> recipes = new HashSet<>();

    public Cuisine() {
    }

    public Cuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public long getId() {
        return id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    @Override
    public  final String toString() {
        return "Cuisine{" +
                "id=" + id +
                ", cuisine='" + cuisine + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
