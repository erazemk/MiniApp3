package si.uni_lj.fri.pbd.miniapp3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails

@Dao
interface RecipeDao {

    @Insert
    fun insertRecipe(recipe: RecipeDetails)

    @Query("SELECT * FROM RecipeDetails WHERE idDrink = :idDrink")
    fun findRecipe(idDrink: String?): RecipeDetails?

    @Query("DELETE FROM RecipeDetails WHERE idDrink = :recipeId")
    fun deleteRecipe(recipeId: String?)

    @get:Query("SELECT * FROM RecipeDetails")
    val allRecipes: LiveData<List<RecipeDetails>>

}
