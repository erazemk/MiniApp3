package si.uni_lj.fri.pbd.miniapp3.rest

import retrofit2.Call
import retrofit2.http.GET
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIdDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIngredientDTO

interface RestAPI {

    @get:GET("list.php?i=list")
    val allIngredients: Call<IngredientsDTO?>?

    @get:GET("filter.php?i={ingredient}")
    val mainIngredient: Call<RecipesByIngredientDTO?>?

    @get:GET("lookup.php?i={id}")
    val recipeById: Call<RecipesByIdDTO?>?

}
