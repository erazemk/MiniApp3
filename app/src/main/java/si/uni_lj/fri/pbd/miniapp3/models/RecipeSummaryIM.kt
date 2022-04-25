package si.uni_lj.fri.pbd.miniapp3.models

class RecipeSummaryIM(
    private val strDrink: String,
    private val strDrinkThumb: String,
    private val idDrink: String
) {

    override fun toString(): String {
        return "RecipeSummaryIM {" +
                "strDrink='" + strDrink + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", idDrink='" + idDrink + '\'' +
                '}'
    }

}
