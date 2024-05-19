package com.example.pruebaproyecto2.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebaproyecto2.R

class Login : AppCompatActivity() {
    lateinit var imgWifi :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        imgWifi = findViewById(R.id.img_wifi)

    }
    fun btnClick(view: View) {

        if(isNetworkAvailable(this)){
            imgWifi.setImageResource(R.drawable.siwifi)
            Toast.makeText(this,resources.getString(R.string.ClickEn), Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            imgWifi.setImageResource(R.drawable.nowifi)
            Toast.makeText(this,resources.getString(R.string.Nohay), Toast.LENGTH_SHORT).show()
        }

    }
    fun isNetworkAvailable(context: Context):Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val networkCapabilities = connectivityManager.activeNetwork?: return false
            val networkInfo = connectivityManager.getNetworkCapabilities(networkCapabilities)?: return false
            return networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
        else{
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected

        }
    }
}
