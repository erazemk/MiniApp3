package si.uni_lj.fri.pbd.miniapp3.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import si.uni_lj.fri.pbd.miniapp3.database.Database
import si.uni_lj.fri.pbd.miniapp3.database.dao.RecipeDao
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipesByIngredientDTO
import si.uni_lj.fri.pbd.miniapp3.rest.RestAPI
import si.uni_lj.fri.pbd.miniapp3.rest.ServiceGenerator
import timber.log.Timber

class RecipeRepository(application: Application) {

    val searchResults = MutableLiveData<List<RecipeDetails>>()
    val recipeById = MutableLiveData<RecipeDetails>()
    //val favorites = LiveData<List<RecipeDetailsIM>>?
    val allRecipes: LiveData<List<RecipeDetails>>?
    private val recipeDao: RecipeDao?

    init {
        val db: Database? = application.let {
            Database.getDatabase(it.applicationContext)
        }

        recipeDao = db?.recipeDao()
        allRecipes = recipeDao?.allRecipes
    }

    fun insertRecipe(recipe: RecipeDetails) {
        Database.databaseWriteExecutor.execute {
            recipeDao?.insertRecipe(recipe)
        }
    }

    fun deleteRecipe(recipeId: String) {
        Database.databaseWriteExecutor.execute {
            recipeDao?.deleteRecipe(recipeId)
        }
    }

    fun findRecipe(recipeId: String) {
        Database.databaseWriteExecutor.execute {
            recipeById.postValue(recipeDao?.findRecipe(recipeId))
        }
    }

    fun getIngredients(): IngredientsDTO {
        val api = ServiceGenerator.createService(RestAPI::class.java)
        val call = api.allIngredients
        var allIngredients: IngredientsDTO

        call.enqueue(object: Callback<IngredientsDTO?> {
            override fun onResponse(
                call: Call<IngredientsDTO?>,
                response: Response<IngredientsDTO?>
            ) {
                if (response.isSuccessful) {
                    val jsonData = response.body()
                    Timber.d("Json: %s", jsonData)
                    //val root = JSONObject(jsonData)

                    //allIngredients = response.body() as IngredientsDTO
                } else {
                    Timber.d("Unsuccessful response to get all ingredients")
                }
            }

            override fun onFailure(call: Call<IngredientsDTO?>, t: Throwable) {
                Timber.d("Failed response to get all ingredients")
            }
        })

        return IngredientsDTO()
    }

    fun getRecipesByIngredient(ingredient: String?): RecipesByIngredientDTO {
        val api = ServiceGenerator.createService(RestAPI::class.java)
        val call = api.getByIngredient(ingredient)
        val recipes: RecipesByIngredientDTO

        call?.enqueue(object: Callback<RecipesByIngredientDTO?> {
            override fun onResponse(
                call: Call<RecipesByIngredientDTO?>,
                response: Response<RecipesByIngredientDTO?>
            ) {
                if (response.isSuccessful) {
                    val jsonData = response.body()
                    Timber.d("Json: %s", jsonData)
                } else {
                    Timber.d("Unsuccessful response to get drinks by ingredient")
                }
            }

            override fun onFailure(call: Call<RecipesByIngredientDTO?>, t: Throwable) {
                Timber.d("Failed response to get drinks by ingredient")
            }
        })

        return RecipesByIngredientDTO()
    }

}
