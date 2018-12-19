use recipes;
select tr.name, tr.description, tr.instructions,ti.name, tc.course, tf.food_category, tm.meal
from   tblrecipe as tr
  join tblrecipeingredient as tri
	on tr.recipe_id = tri.recipe_id
  join tblingredient as ti
    on tri.ingredient_id = ti.ingredient_id
  join tblrecipecourse as trc
	on tr.recipe_id = tr.recipe_id
  join tblcourse as tc
    on trc.course_id = tc.course_id
  join tblrecipefoodcategory as trf
    on tr.recipe_id = trf.recipe_id
  join tblfoodcategory as tf
    on trf.food_category_id = tf.food_category_id
  join tblrecipemeals as trm
    on tr.recipe_id = trm.recipe_id
  join tblmeal as tm
    on trm.meal_id=tm.meal_id
