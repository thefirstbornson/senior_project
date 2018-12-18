package datasets;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tblRecipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recipe_id")
    long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="instructions")
    private String instructions;

    @Column(name="cooktime", columnDefinition="TIME")
    @Temporal(TemporalType.TIME)
    private  Date cooktime;

    @Column(name="level_id")
    private int level_id;

    @Column(name="cuisine_id")
    private int cousine_id;

    @Column(name="rating")
    private int rating;

    @Column(name="imagepath")
    private String imagepath;

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    public Recipe(){}

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredients.add(recipeIngredient);
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Date getCooktime() {
        return cooktime;
    }

    public void setCooktime(Date cooktime) {
        this.cooktime = cooktime;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public int getCousine_id() {
        return cousine_id;
    }

    public void setCousine_id(int cousine_id) {
        this.cousine_id = cousine_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Recipe(String name, String description, String instructions, Date cooktime
            , int level_id, int cousine_id, int rating, String imagepath) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.cooktime = cooktime;
        this.level_id = level_id;
        this.cousine_id = cousine_id;
        this.rating = rating;
        this.imagepath = imagepath;
    }
}
