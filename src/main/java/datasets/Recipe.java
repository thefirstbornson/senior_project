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
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="instructions")
    private String instructions;

    @Column(name="cooktime", columnDefinition="TIME")
    @Temporal(TemporalType.TIME)
    private  Date cooktime;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cousine;

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

//    @OneToMany(mappedBy = "recipe")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tblRecipeCourse"
           ,joinColumns = @JoinColumn(name="recipe_id")
           ,inverseJoinColumns = @JoinColumn(name = "course_id" )
    )
    private Set<Course> recipeCourses = new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeFoodCategory> recipeFoodCategories = new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeMeal> recipeMeals = new HashSet<>();

    public Recipe(){}

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredients.add(recipeIngredient);
    }

    public void addCourse (Course course){
        this.recipeCourses.add(course);
    }

    public void addRecipeFoodCategory (RecipeFoodCategory recipeFoodCategory){
        this.recipeFoodCategories.add(recipeFoodCategory);
    }

    public void addRecipeMeal (RecipeMeal recipeMeal){
        this.recipeMeals.add(recipeMeal);
    }

    public Set<Course> getRecipeCourses() {
        return recipeCourses;
    }

    public Set<RecipeFoodCategory> getRecipeFoodCategories() {
        return recipeFoodCategories;
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

    public Recipe( String name, String description, String instructions, Date cooktime, Level level, Cuisine cousine, int rating, String imagepath) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.cooktime = cooktime;
        this.level = level;
        this.cousine = cousine;
        this.rating = rating;
        this.imagepath = imagepath;
    }
}
