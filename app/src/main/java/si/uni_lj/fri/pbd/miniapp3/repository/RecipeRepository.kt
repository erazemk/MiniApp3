package si.uni_lj.fri.pbd.miniapp3.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import si.uni_lj.fri.pbd.miniapp3.database.Database
import si.uni_lj.fri.pbd.miniapp3.database.dao.RecipeDao
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails

class RecipeRepository(application: Application) {

    val searchResults = MutableLiveData<List<RecipeDetails>>()
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
            searchResults.postValue(recipeDao?.findRecipe(recipeId))
        }
    }

}
