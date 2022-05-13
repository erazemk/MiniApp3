package si.uni_lj.fri.pbd.miniapp3.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.repository.RecipeRepository

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    var favorites: LiveData<List<RecipeDetails>>?
    private val repository: RecipeRepository = RecipeRepository(application)

    init {
        favorites = repository.allRecipes
    }
}
