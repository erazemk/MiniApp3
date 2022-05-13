package si.uni_lj.fri.pbd.miniapp3.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.repository.RecipeRepository
import timber.log.Timber

class DetailsViewModel(application: Application) : AndroidViewModel(application) {

    val recipe: MutableLiveData<RecipeDetails>?
    val favorites: LiveData<List<RecipeDetails>>?
    private val repository: RecipeRepository = RecipeRepository(application)

    init {
        recipe = repository.searchRecipe
        favorites = repository.allRecipes
    }

    fun getRecipe(recipeId: String, caller: String) {
        Timber.d("Called DetailsViewModel.getRecipe(%s, %s)", recipeId, caller)
        if (caller == "SearchFragment") {
            // Download recipe
            repository.findRecipeById(recipeId)
        } else if (caller == "FavoritesFragment") {
            // Get recipe from database
            repository.findRecipe(recipeId)
        }
    }

    fun addRecipe(recipe: RecipeDetails) {
        repository.insertRecipe(recipe)
    }

    fun removeRecipe(recipe: RecipeDetails) {
        repository.deleteRecipe(recipe.idDrink!!)
    }

}
