package si.uni_lj.fri.pbd.miniapp3.adapter

import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipeSummaryDTO
import si.uni_lj.fri.pbd.miniapp3.ui.DetailsActivity
import timber.log.Timber
import java.io.IOException
import java.net.URL

class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder>() {

    inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var recipeId: String? = null
        var recipeName: TextView? = null
        var recipeThumbnail: ImageView? = null

        init {
            recipeName = itemView?.findViewById(R.id.recipeTextView)
            recipeThumbnail = itemView?.findViewById(R.id.recipeImageView)
        }
    }

    private var recipes: List<RecipeSummaryDTO>? = null

    fun setRecipes(recipes: List<RecipeSummaryDTO>?) {
        this.recipes = recipes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_grid_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val bitmap: Bitmap? = getBitmapFromUrl(recipes?.get(position)?.strDrinkThumb!!)

        holder.apply {
            recipeId = recipes?.get(position)?.idDrink
            recipeName?.text = recipes?.get(position)?.strDrink
            recipeThumbnail?.setImageBitmap(bitmap)

            // Open DetailsActivity and pass the clicked drink's ID to it
            itemView.setOnClickListener {
                val activity = it.context as? AppCompatActivity
                val intent = Intent(activity, DetailsActivity::class.java)
                    .putExtra("recipeId", recipes!![position].idDrink)
                activity?.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        recipes ?: return 0
        return recipes!!.size
    }

    private fun getBitmapFromUrl(url: String): Bitmap? {
        var recipeThumbnail: Bitmap? = null

        CoroutineScope(Job() + Dispatchers.IO).launch {
            recipeThumbnail = try {
                val connection = URL(url)
                val bitmap =
                    BitmapFactory.decodeStream(connection.openConnection().getInputStream())
                Bitmap.createScaledBitmap(bitmap, 100, 100, true)
            } catch (ioe: IOException) {
                Timber.d("Failed to download cocktail image")
                BitmapFactory.decodeResource(
                    Resources.getSystem(),
                    android.R.drawable.picture_frame
                )
            }
        }

        return recipeThumbnail
    }

}
