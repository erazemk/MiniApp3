package si.uni_lj.fri.pbd.miniapp3.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.models.dto.RecipeSummaryDTO
import si.uni_lj.fri.pbd.miniapp3.ui.DetailsActivity
import java.io.InputStream
import java.net.URL

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recipeName: TextView
        var recipeThumbnail: ImageView

        init {
            recipeName = itemView.findViewById(R.id.recipeTextView)
            recipeThumbnail = itemView.findViewById(R.id.recipeImageView)
        }
    }

    private var recipes: List<RecipeSummaryDTO>? = null

    fun setRecipes(recipes: List<RecipeSummaryDTO>?) {
        this.recipes = recipes
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return recipes?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_grid_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = recipes!![position].strDrinkThumb
        val deferredBitmap: Deferred<Bitmap> = CoroutineScope(Dispatchers.IO).async { getThumbnail(url) }

        CoroutineScope(Dispatchers.Main).launch {
            val bitmap: Bitmap = deferredBitmap.await()
            bitmap.apply {
                holder.recipeThumbnail.setImageBitmap(bitmap)
            }
        }

        holder.apply {
            recipeName.text = recipes?.get(position)?.strDrink
            itemView.setOnClickListener {
                val activity = it.context as? AppCompatActivity
                val intent = Intent(activity, DetailsActivity::class.java)
                    .putExtra("recipeId", recipes!![position].idDrink)
                    .putExtra("caller", "SearchFragment")
                activity?.startActivity(intent)
            }
        }
    }

    private fun getThumbnail(url: String?) : Bitmap {
        // Source: https://stackoverflow.com/questions/6407324/how-to-display-image-from-url-on-android
        val inputStream: InputStream = URL(url).content as InputStream
        return Drawable.createFromStream(inputStream, "thumbnail").toBitmap()
    }

}
