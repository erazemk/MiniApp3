package si.uni_lj.fri.pbd.miniapp3.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class RecipeDetailsIM(
    private var isFavorite: Boolean?,
    idDrink: String?,
    strDrink: String?,
    strCategory: String?,
    strIBA: String?,
    strInstructions: String?,
    strDrinkThumb: String?,
    strVideo: String?,
    strIngredient1: String?,
    strIngredient2: String?,
    strIngredient3: String?,
    strIngredient4: String?,
    strIngredient5: String?,
    strIngredient6: String?,
    strIngredient7: String?,
    strIngredient8: String?,
    strIngredient9: String?,
    strIngredient10: String?,
    strIngredient11: String?,
    strIngredient12: String?,
    strIngredient13: String?,
    strIngredient14: String?,
    strIngredient15: String?,
    strMeasure1: String?,
    strMeasure2: String?,
    strMeasure3: String?,
    strMeasure4: String?,
    strMeasure5: String?,
    strMeasure6: String?,
    strMeasure7: String?,
    strMeasure8: String?,
    strMeasure9: String?,
    strMeasure10: String?,
    strMeasure11: String?,
    strMeasure12: String?,
    strMeasure13: String?,
    strMeasure14: String?,
    strMeasure15: String?,
    strImageSource: String?
) : BaseObservable() {
    var idDrink: String? = idDrink
        private set
    var strDrink: String? = strDrink
        private set
    var strCategory: String? = strCategory
        private set
    var strIBA: String? = strIBA
        private set
    var strInstructions: String? = strInstructions
        private set
    var strDrinkThumb: String? = strDrinkThumb
        private set
    var strVideo: String? = strVideo
        private set
    var strIngredient1: String? = strIngredient1
        private set
    var strIngredient2: String? = strIngredient2
        private set
    var strIngredient3: String? = strIngredient3
        private set
    var strIngredient4: String? = strIngredient4
        private set
    var strIngredient5: String? = strIngredient5
        private set
    var strIngredient6: String? = strIngredient6
        private set
    var strIngredient7: String? = strIngredient7
        private set
    var strIngredient8: String? = strIngredient8
        private set
    var strIngredient9: String? = strIngredient9
        private set
    var strIngredient10: String? = strIngredient10
        private set
    var strIngredient11: String? = strIngredient11
        private set
    var strIngredient12: String? = strIngredient12
        private set
    var strIngredient13: String? = strIngredient13
        private set
    var strIngredient14: String? = strIngredient14
        private set
    var strIngredient15: String? = strIngredient15
        private set
    var strMeasure1: String? = strMeasure1
        private set
    var strMeasure2: String? = strMeasure2
        private set
    var strMeasure3: String? = strMeasure3
        private set
    var strMeasure4: String? = strMeasure4
        private set
    var strMeasure5: String? = strMeasure5
        private set
    var strMeasure6: String? = strMeasure6
        private set
    var strMeasure7: String? = strMeasure7
        private set
    var strMeasure8: String? = strMeasure8
        private set
    var strMeasure9: String? = strMeasure9
        private set
    var strMeasure10: String? = strMeasure10
        private set
    var strMeasure11: String? = strMeasure11
        private set
    var strMeasure12: String? = strMeasure12
        private set
    var strMeasure13: String? = strMeasure13
        private set
    var strMeasure14: String? = strMeasure14
        private set
    var strMeasure15: String? = strMeasure15
        private set
    var strImageSource: String? = strImageSource
        private set

    @Bindable
    fun getFavorite(): Boolean? {
        return isFavorite
    }

    fun setFavorite(favorite: Boolean?) {
        isFavorite = favorite
        notifyPropertyChanged(BR.favorite)
    }

    override fun toString(): String {
        return "RecipeDetailsIM {" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", strCategory='" + strCategory + '\'' +
                ", strIBA='" + strIBA + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", strVideo='" + strVideo + '\'' +
                ", strIngredient1='" + strIngredient1 + '\'' +
                ", strIngredient2='" + strIngredient2 + '\'' +
                ", strIngredient3='" + strIngredient3 + '\'' +
                ", strIngredient4='" + strIngredient4 + '\'' +
                ", strIngredient5='" + strIngredient5 + '\'' +
                ", strIngredient6='" + strIngredient6 + '\'' +
                ", strIngredient7='" + strIngredient7 + '\'' +
                ", strIngredient8='" + strIngredient8 + '\'' +
                ", strIngredient9='" + strIngredient9 + '\'' +
                ", strIngredient10='" + strIngredient10 + '\'' +
                ", strIngredient11='" + strIngredient11 + '\'' +
                ", strIngredient12='" + strIngredient12 + '\'' +
                ", strIngredient13='" + strIngredient13 + '\'' +
                ", strIngredient14='" + strIngredient14 + '\'' +
                ", strIngredient15='" + strIngredient15 + '\'' +
                ", strMeasure1='" + strMeasure1 + '\'' +
                ", strMeasure2='" + strMeasure2 + '\'' +
                ", strMeasure3='" + strMeasure3 + '\'' +
                ", strMeasure4='" + strMeasure4 + '\'' +
                ", strMeasure5='" + strMeasure5 + '\'' +
                ", strMeasure6='" + strMeasure6 + '\'' +
                ", strMeasure7='" + strMeasure7 + '\'' +
                ", strMeasure8='" + strMeasure8 + '\'' +
                ", strMeasure9='" + strMeasure9 + '\'' +
                ", strMeasure10='" + strMeasure10 + '\'' +
                ", strMeasure11='" + strMeasure11 + '\'' +
                ", strMeasure12='" + strMeasure12 + '\'' +
                ", strMeasure13='" + strMeasure13 + '\'' +
                ", strMeasure14='" + strMeasure14 + '\'' +
                ", strMeasure15='" + strMeasure15 + '\'' +
                ", strImageSource='" + strImageSource + '\'' +
                '}'
    }

    fun setValue(recipeDetails: RecipeDetailsIM) {
        this.isFavorite = recipeDetails.isFavorite
        this.idDrink = recipeDetails.idDrink
        this.strDrink = recipeDetails.strDrink
        this.strCategory = recipeDetails.strCategory
        this.strIBA = recipeDetails.strIBA
        this.strInstructions = recipeDetails.strInstructions
        this.strDrinkThumb = recipeDetails.strDrinkThumb
        this.strVideo = recipeDetails.strVideo
        this.strIngredient1 = recipeDetails.strIngredient1
        this.strIngredient2 = recipeDetails.strIngredient2
        this.strIngredient3 = recipeDetails.strIngredient3
        this.strIngredient4 = recipeDetails.strIngredient4
        this.strIngredient5 = recipeDetails.strIngredient5
        this.strIngredient6 = recipeDetails.strIngredient6
        this.strIngredient7 = recipeDetails.strIngredient7
        this.strIngredient8 = recipeDetails.strIngredient8
        this.strIngredient9 = recipeDetails.strIngredient9
        this.strIngredient10 = recipeDetails.strIngredient10
        this.strIngredient11 = recipeDetails.strIngredient11
        this.strIngredient12 = recipeDetails.strIngredient12
        this.strIngredient13 = recipeDetails.strIngredient13
        this.strIngredient14 = recipeDetails.strIngredient14
        this.strIngredient15 = recipeDetails.strIngredient15
        this.strMeasure1 = recipeDetails.strMeasure1
        this.strMeasure2 = recipeDetails.strMeasure2
        this.strMeasure3 = recipeDetails.strMeasure3
        this.strMeasure4 = recipeDetails.strMeasure4
        this.strMeasure5 = recipeDetails.strMeasure5
        this.strMeasure6 = recipeDetails.strMeasure6
        this.strMeasure7 = recipeDetails.strMeasure7
        this.strMeasure8 = recipeDetails.strMeasure8
        this.strMeasure9 = recipeDetails.strMeasure9
        this.strMeasure10 = recipeDetails.strMeasure10
        this.strMeasure11 = recipeDetails.strMeasure11
        this.strMeasure12 = recipeDetails.strMeasure12
        this.strMeasure13 = recipeDetails.strMeasure13
        this.strMeasure14 = recipeDetails.strMeasure14
        this.strMeasure15 = recipeDetails.strMeasure15
        this.strImageSource = recipeDetails.strImageSource
    }
}
