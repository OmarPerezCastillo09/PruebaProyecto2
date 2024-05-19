package com.example.pruebaproyecto2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable

import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.pruebaproyecto2.R
import com.example.pruebaproyecto2.data.remote.AvatarApi
import com.example.pruebaproyecto2.data.remote.model.AvatarDetailDto
import com.example.pruebaproyecto2.data.remote.model.AvatarDto
import com.example.pruebaproyecto2.databinding.ActivityDetallesBinding
import com.example.pruebaproyecto2.databinding.AvatarElementBinding
import com.example.pruebaproyecto2.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Detalles : AppCompatActivity() {
    private lateinit var  binding: ActivityDetallesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

       val id = bundle?.getString("id","")
        Log.d(Constants.LOGTAG,"id recibido $id")
       val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val avatarApi = retrofit.create(AvatarApi::class.java)
        val call: Call<AvatarDetailDto> = avatarApi.getAvatarDetails(id!!)

        call.enqueue(object: Callback<AvatarDetailDto>{
            override fun onResponse(p0: Call<AvatarDetailDto>, response: Response<AvatarDetailDto>) {

                binding.pbLoading.visibility = View.INVISIBLE

                binding.apply {
                    tvName.text = response.body()?.name
                    tvGenero.text = response.body()?.gender
                    tvPosicion.text = response.body()?.position
                    tvProfesion.text = response.body()?.profession
                    Glide.with(this@Detalles)
                        .load(response.body()?.image)
                        .into(ivImagen)
                    /*
                    Usado para determinar su afiliacion prueba
                    Glide.with(this@Detalles)
                       .load(response.body()?.affiliation?.let { maestro_elemento(it) })
                        .into(binding.ivElement)*/
                    Glide.with(this@Detalles)
                        .load(response.body()?.weapon?.let { maestro_elemento(it) })
                        .into(binding.ivElement)
                }

            }

            override fun onFailure(p0: Call<AvatarDetailDto>, p1: Throwable) {
                //Error de Conexion
                binding.pbLoading.visibility = View.INVISIBLE
                Toast.makeText(this@Detalles,resources.getString(R.string.Nohay), Toast.LENGTH_SHORT).show()
            }

        })



    }

    /*@SuppressLint("UseCompatLoadingForDrawables")
    fun maestro_elemento(element: String): Drawable? {
        return when {

            //PARA LA NACION AGUA
            element.contains("Water Tribe ", ignoreCase = true) -> getDrawable(R.drawable.agua)
            element.contains("Northern Water Tribe", ignoreCase = true) -> getDrawable(R.drawable.agua)
            //PARA LA NACION FUEGO
            element.contains("Fire Nation", ignoreCase = true) -> getDrawable(R.drawable.fuego)
            element.contains("Fire Nation Military", ignoreCase = true) -> getDrawable(R.drawable.fuego)
            element.contains("Fire Nation school", ignoreCase = true) -> getDrawable(R.drawable.fuego)
            //Para la nacion aire
            element.contains("Air Nation", ignoreCase = true) -> getDrawable(R.drawable.aire)
            element.contains("Air Nomads", ignoreCase = true) -> getDrawable(R.drawable.aire)
            element.contains("Air Nomads Team Avatar", ignoreCase = true) -> getDrawable(R.drawable.aire)
             // Para la nacion tierra
            element.contains("Earth Kingdom Military", ignoreCase = true) -> getDrawable(R.drawable.tierra)
            element.contains("Earth Kingdom", ignoreCase = true) -> getDrawable(R.drawable.tierra)
            else -> null
        }
    }*/
    @SuppressLint("UseCompatLoadingForDrawables")
    fun maestro_elemento(element: String): Drawable? {
        return when {

            //PARA LA NACION AGUA
            element.contains("Water", ignoreCase = true) -> getDrawable(R.drawable.agua)
            //PARA LA NACION FUEGO
            element.contains("Fire", ignoreCase = true) -> getDrawable(R.drawable.fuego)
            //Para la nacion aire
            element.contains("Air", ignoreCase = true) -> getDrawable(R.drawable.aire)
            // Para la nacion tierra
            element.contains("Earth", ignoreCase = true) -> getDrawable(R.drawable.tierra)

            else -> null
        }

    }


}