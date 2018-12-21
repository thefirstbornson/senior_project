-- start the server: $ mysqld --console
-- login:            $ mysql -u root --password=wxyz
-- run the script:   mysql> source /Users/javapro/dev/src/sql/Cookbook.sql
-- the script: 

drop database if exists Recipes;

create database Recipes; 

use Recipes; 

create table tblIngredient (
	ingredient_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50))
	ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table tblMeasurement (
	measurement_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(30)) 
	ENGINE=InnoDB DEFAULT CHARSET=utf8; 
    
create table tblFoodCategory (
	food_category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    food_category  VARCHAR(30)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;   
    
create table tblCourse (
	course_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    course VARCHAR(30)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8; 

create table tblMeal (
	meal_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    meal VARCHAR(50)
    )
	ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table tblLevel (
	level_id INT NOT NULL PRIMARY KEY
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table tblCuisine (
	cuisine_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cuisine VARCHAR(50)
    )
	ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table tblNutritionalInformation (
	nutrition_infromation_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nutrition VARCHAR(30))
    ENGINE=InnoDB DEFAULT CHARSET=utf8; 
    
CREATE TABLE tblRecipe(
    recipe_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25),
    description VARCHAR(50),
    instructions VARCHAR(500),
    cooktime TIME NULL,
    level_id INT NULL,
    cuisine_id INT NULL,
    rating INT,
    imagepath VARCHAR(255)
     ,CONSTRAINT fk_level FOREIGN KEY(level_id) REFERENCES tblLevel(level_id)
     ,CONSTRAINT fk_cuisine FOREIGN KEY(cuisine_id) REFERENCES tblCuisine(cuisine_id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;
    

create table tblRecipeIngredient (
	recipe_ingredient_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	recipe_id INT NOT NULL, 
	ingredient_id INT NOT NULL, 
	measurement_id INT , 
	amount INT
    , CONSTRAINT fk_ri_recipe FOREIGN KEY(recipe_id) REFERENCES tblRecipe(recipe_id)
    , CONSTRAINT fk_ri_ingredient FOREIGN KEY(ingredient_id) REFERENCES tblIngredient(ingredient_id) 
    , CONSTRAINT fk_ri_measure FOREIGN KEY(measurement_id) REFERENCES tblMeasurement(measurement_id)
    )
	ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    
create table tblIngredientNutritionalInformation (
	rni_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ingredient_id INT NOT NULL,
    ni_id INT NOT NULL,
    amount INT,
     CONSTRAINT fk_ini_recipe FOREIGN KEY(ingredient_id) REFERENCES tblIngredient(ingredient_id),
     CONSTRAINT fk_ini_nutritionalinformation FOREIGN KEY(ni_id) REFERENCES tblNutritionalInformation(nutrition_infromation_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8; 
    
    -- ####################### composite primary key in link tables for ManyToMany connection in Hibernate #######################
    
create table tblRecipeCourse (
    recipe_id INT NOT NULL, 
	course_id INT NOT NULL,
     PRIMARY KEY (recipe_id,course_id),
     CONSTRAINT fk_rc_recipe FOREIGN KEY(recipe_id) REFERENCES tblRecipe(recipe_id),
     CONSTRAINT fk_rc_course FOREIGN KEY(course_id) REFERENCES tblCourse(course_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;   
    
    
create table tblRecipeFoodCategory (
    recipe_id INT NOT NULL, 
    food_category_id INT NOT NULL, 
      PRIMARY KEY (recipe_id,food_category_id),
      CONSTRAINT fk_rfc_recipe FOREIGN KEY(recipe_id) REFERENCES tblRecipe(recipe_id),
      CONSTRAINT fk_rfc_food_category FOREIGN KEY(food_category_id) REFERENCES tblFoodCategory(food_category_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    
create table tblRecipeMeals (
    recipe_id INT NOT NULL, 
	meal_id INT NOT NULL,
      PRIMARY KEY (recipe_id,meal_id),
      CONSTRAINT fk_rm_recipe FOREIGN KEY(recipe_id) REFERENCES tblRecipe(recipe_id),
      CONSTRAINT fk_rm_meal FOREIGN KEY(meal_id) REFERENCES tblMeal(meal_id)
    )
	ENGINE=InnoDB DEFAULT CHARSET=utf8;
