package datasets;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tblLevel")
public class Level {
    @Id
    @Column(name="level_id")
    private long id;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Recipe> recipes = new HashSet<>();

    public Level() {
    }

    public Level(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
