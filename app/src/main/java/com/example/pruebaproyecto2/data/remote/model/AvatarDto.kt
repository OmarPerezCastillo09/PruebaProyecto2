package com.example.pruebaproyecto2.data.remote.model

import com.google.gson.annotations.SerializedName

data class AvatarDto(
    @SerializedName("_id")
    var id: String,
    @SerializedName("photoUrl")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("affiliation")
    var affiliation: String


    /*@SerializedName("allies")
      var allies: String,
      @SerializedName("enemies")
      var enemies: String,*/


)
