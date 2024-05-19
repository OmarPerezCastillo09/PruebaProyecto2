package com.example.pruebaproyecto2.data.remote

import com.example.pruebaproyecto2.data.remote.model.AvatarDetailDto
import com.example.pruebaproyecto2.data.remote.model.AvatarDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface AvatarApi {
     // https://last-airbender-api.fly.dev/api/v1/characters?perPage=497
    @GET
    fun getAvatars(
        @Url url: String

    ): Call <List<AvatarDto>>




    @GET("api/v1/characters/{id}")
    fun getAvatarDetails(
        @Path("id") id: String

    ): Call <AvatarDetailDto>
}