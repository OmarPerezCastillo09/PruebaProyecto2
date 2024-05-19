package com.example.pruebaproyecto2.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaproyecto2.data.remote.model.AvatarDto
import com.example.pruebaproyecto2.databinding.ActivityMainBinding
import com.example.pruebaproyecto2.databinding.AvatarElementBinding

class AvatarViewHolder(
    private val binding: AvatarElementBinding
): RecyclerView.ViewHolder(binding.root) {

    val ivImagen = binding.ivImagen

    fun bind(avatar: AvatarDto){
         binding.tvName.text = avatar.name
         binding.tvAfiliacion.text = avatar.affiliation
    }

}