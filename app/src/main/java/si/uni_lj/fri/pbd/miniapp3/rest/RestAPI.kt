package si.uni_lj.fri.pbd.miniapp3.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIdDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIngredientDTO

// Source: https://www.vogella.com/tutorials/Retrofit/article.html
interface RestAPI {

    @get:GET("list.php?i=list")
    val allIngredients: Call<IngredientsDTO?>?

    @GET("filter.php?a=Non_Alcoholic")
    fun getSemesterModeDrinks() : Call<RecipesByIdDTO>

    @GET("filter.php")
    fun getByIngredient(@Query("i") ingredient: String?): Call<RecipesByIngredientDTO?>?

    @GET("lookup.php")
    fun getRecipeById(@Query("i") id: String?): Call<RecipesByIdDTO?>?

}
