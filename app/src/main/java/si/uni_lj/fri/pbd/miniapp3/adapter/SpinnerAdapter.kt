package si.uni_lj.fri.pbd.miniapp3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import si.uni_lj.fri.pbd.miniapp3.R
import si.uni_lj.fri.pbd.miniapp3.models.dto.IngredientsDTO

class SpinnerAdapter(private val ingredients: IngredientsDTO) : BaseAdapter() {

    override fun getCount(): Int {
        return ingredients.ingredients?.size ?: 0
    }

    override fun getItem(position: Int): String? {
        return ingredients.ingredients!![position].strIngredient1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: Ingredient

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.spinner_item, parent, false)
            viewHolder = Ingredient(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as Ingredient
        }

        viewHolder.name.text = ingredients.ingredients!![position].strIngredient1
        return view
    }

    private class Ingredient(row: View?) {
        val name: TextView

        init {
            name = row?.findViewById(R.id.text_view_spinner_item) as TextView
        }
    }

}
