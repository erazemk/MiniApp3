package si.uni_lj.fri.pbd.miniapp3.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.repository.RecipeRepository

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    var searchResults = MutableLiveData<List<RecipeDetails>>()
    var allRecipes: LiveData<List<RecipeDetails>>?
    private val repository: RecipeRepository = RecipeRepository(application)

    init {
        searchResults = repository.searchResults
        allRecipes = repository.allRecipes
    }

    fun findRecipe(recipeId: String) {
        repository.findRecipe(recipeId)
    }

    fun insertRecipe(recipe: RecipeDetails) {
        repository.insertRecipe(recipe)
    }

    fun deleteRecipe(recipeId: String) {
        repository.deleteRecipe(recipeId)
    }

}
