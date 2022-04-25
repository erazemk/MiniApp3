package si.uni_lj.fri.pbd.miniapp3.rest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import si.uni_lj.fri.pbd.miniapp3.models.dto.*

interface RestAPI {

    @get:GET("list.php?i=list")
    val allIngredients: Call<IngredientsDTO?>?

    // TODO: Add missing endpoints
}
