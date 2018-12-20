use recipes;
select tr.name, tr.description, tr.instructions,ti.name, tc.course, tf.food_category, tm.meal
		,(select sum(tri2.amount)
		  from tblrecipeingredient as tri2
          where tri2.recipe_id = tri.recipe_id)as weight
        ,(select  tin3.amount
          from tblrecipeingredient as tri3
            join tblingredient as ti3 
 			 on tri3.ingredient_id = ti3.ingredient_id
            join tblingredientnutritionalInformation as tin3
              on ti3.ingredient_id = tin3.ingredient_id
            join tblnutritionalInformation as tn3
              on tin3.ni_id=tn3.nutrition_infromation_id
          where  tn3.nutrition_infromation_id=1
			and tri3.recipe_id = tri.recipe_id ) as Protein
         ,(select  tin3.amount
          from tblrecipeingredient as tri3
            join tblingredient as ti3 
 			 on tri3.ingredient_id = ti3.ingredient_id
            join tblingredientnutritionalInformation as tin3
              on ti3.ingredient_id = tin3.ingredient_id
            join tblnutritionalInformation as tn3
              on tin3.ni_id=tn3.nutrition_infromation_id
          where  tn3.nutrition_infromation_id=2
			and tri3.recipe_id = tri.recipe_id ) as Fat  
         ,(select  tin3.amount
          from tblrecipeingredient as tri3
            join tblingredient as ti3 
 			 on tri3.ingredient_id = ti3.ingredient_id
            join tblingredientnutritionalInformation as tin3
              on ti3.ingredient_id = tin3.ingredient_id
            join tblnutritionalInformation as tn3
              on tin3.ni_id=tn3.nutrition_infromation_id
          where  tn3.nutrition_infromation_id=3
			and tri3.recipe_id = tri.recipe_id ) as Carbohydrate
           , ((select(Protein) * 4) + (select(Fat)*9) + (select(Carbohydrate)*4)) as Energy

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
