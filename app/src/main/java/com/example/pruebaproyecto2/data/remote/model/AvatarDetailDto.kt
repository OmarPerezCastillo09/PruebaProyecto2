package com.example.pruebaproyecto2.data.remote.model

import com.google.gson.annotations.SerializedName

data class AvatarDetailDto(

    @SerializedName("photoUrl")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("profession")
    var profession: String,
    @SerializedName("position")
    var position: String,
    @SerializedName("affiliation")
   var affiliation: String,
    @SerializedName("weapon")
    var weapon: String


)
