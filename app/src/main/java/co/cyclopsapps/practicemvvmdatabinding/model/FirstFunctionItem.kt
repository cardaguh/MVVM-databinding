package co.cyclopsapps.practicemvvmdatabinding.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FirstFunctionItem (
    @SerializedName("image") val image : String,
    @SerializedName("route") val route : String,
    @SerializedName("title") val title : String,
    @SerializedName("visible") val visible : Boolean,
    @SerializedName("url") val url : String,
    @SerializedName("loginRequired") val loginRequired : Boolean,
): Serializable
