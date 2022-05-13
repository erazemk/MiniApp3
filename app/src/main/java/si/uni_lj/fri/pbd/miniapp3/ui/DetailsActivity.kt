package si.uni_lj.fri.pbd.miniapp3.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails
import si.uni_lj.fri.pbd.miniapp3.databinding.ActivityDetailsBinding
import si.uni_lj.fri.pbd.miniapp3.models.DetailsViewModel
import timber.log.Timber
import java.io.InputStream
import java.net.URL

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private var dViewModel: DetailsViewModel? = null
    private var imageView: ImageView? = null
    private var recipeName: TextView? = null
    private var recipeIngredients: TextView? = null
    private var recipeMeasures: TextView? = null
    private var recipeInstructions: TextView? = null
    private var favoritesButton: Button? = null

    private var recipe: RecipeDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.detailsImage
        recipeName = binding.detailsRecipeName
        recipeIngredients = binding.detailsIngredients
        recipeMeasures = binding.detailsMeasures
        recipeInstructions = binding.detailsInstructions
        favoritesButton = binding.detailsButton
        favoritesButton?.text = getString(R.string.favorite)

        val recipeId = intent.getStringExtra("recipeId") as String
        val caller = intent.getStringExtra("caller") as String
        Timber.d("Intent: recipeId=%s, caller=%s", recipeId, caller)

        dViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        dViewModel?.getRecipe(recipeId, caller)

        observerSetup()

        favoritesButton?.setOnClickListener {
            Timber.d("Clicked on favorites button, state=%b", recipe?.favorite)
            if (recipe?.favorite == false) { // Add to database
                recipe?.favorite = true
                Timber.d("Added recipe to favorites")
                favoritesButton?.text = getString(R.string.unfavorite)
                dViewModel?.addRecipe(recipe!!)
            } else { // Remove from database
                recipe?.favorite = false
                Timber.d("Removed recipe from favorites")
                favoritesButton?.text = getString(R.string.favorite)
                dViewModel?.removeRecipe(recipe!!)
            }
        }
    }

    private fun observerSetup() {
        dViewModel?.recipe?.observe(this) { recipe ->
            this.recipe = recipe
            setLayout()
        }
    }

    private fun setLayout() {
        // Set favorites button based on state
        if (recipe?.favorite == true) {
            favoritesButton?.text = getString(R.string.unfavorite)
        } else {
            favoritesButton?.text = getString(R.string.favorite)
        }

        val ingredients = mutableListOf(
            recipe!!.strIngredient1,
            recipe!!.strIngredient2,
            recipe!!.strIngredient3,
            recipe!!.strIngredient5,
            recipe!!.strIngredient4,
            recipe!!.strIngredient6,
            recipe!!.strIngredient7,
            recipe!!.strIngredient8,
            recipe!!.strIngredient9,
            recipe!!.strIngredient10,
            recipe!!.strIngredient11,
            recipe!!.strIngredient12,
            recipe!!.strIngredient13,
            recipe!!.strIngredient14,
            recipe!!.strIngredient15
        )

        val measures = mutableListOf(
            recipe!!.strMeasure1,
            recipe!!.strMeasure2,
            recipe!!.strMeasure3,
            recipe!!.strMeasure5,
            recipe!!.strMeasure4,
            recipe!!.strMeasure6,
            recipe!!.strMeasure7,
            recipe!!.strMeasure8,
            recipe!!.strMeasure9,
            recipe!!.strMeasure10,
            recipe!!.strMeasure11,
            recipe!!.strMeasure12,
            recipe!!.strMeasure13,
            recipe!!.strMeasure14,
            recipe!!.strMeasure15
        )

        // Remove null elements
        ingredients.removeAll(listOf(null))
        measures.removeAll(listOf(null))

        recipeName?.text = recipe!!.strDrink
        recipeIngredients?.text = ingredients.joinToString(", ")
        recipeMeasures?.text = measures.joinToString(", ")
        recipeInstructions?.text = recipe!!.strInstructions

        val deferredImage: Deferred<Bitmap> = CoroutineScope(Dispatchers.IO).async {
            getImage(recipe!!.strDrinkThumb)
        }

        CoroutineScope(Dispatchers.Main).launch {
            val bitmap: Bitmap = deferredImage.await()
            bitmap.apply { imageView?.setImageBitmap(bitmap) }
        }
    }

    private fun getImage(url: String?) : Bitmap {
        // Source: https://stackoverflow.com/questions/6407324/how-to-display-image-from-url-on-android
        val inputStream: InputStream = URL(url).content as InputStream
        return Drawable.createFromStream(inputStream, "image").toBitmap()
    }

}
