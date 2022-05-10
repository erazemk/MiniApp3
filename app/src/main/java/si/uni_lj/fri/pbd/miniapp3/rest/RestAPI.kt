package si.uni_lj.fri.pbd.miniapp3.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIdDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIngredientDTO

// Source: https://www.vogella.com/tutorials/Retrofit/article.html
interface RestAPI {

    @get:GET("list.php?i=list")
    val allIngredients: Call<IngredientsDTO?>?

    @GET("filter.php?i={ingredient}")
    fun getByIngredient(@Path("ingredient") ingredient: String?): Call<RecipesByIngredientDTO?>?

    @GET("lookup.php?i={id}")
    fun getRecipeById(@Path("id") id: String?): Call<RecipesByIdDTO?>?

}
