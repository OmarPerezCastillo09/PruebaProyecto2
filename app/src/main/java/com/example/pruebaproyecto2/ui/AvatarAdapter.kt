package com.example.pruebaproyecto2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebaproyecto2.data.remote.model.AvatarDto
import com.example.pruebaproyecto2.databinding.AvatarElementBinding
import com.squareup.picasso.Picasso

class AvatarAdapter(
    private val avatars: List<AvatarDto>,
    private val onAvatarClicked: (AvatarDto) -> Unit
): RecyclerView.Adapter<AvatarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
         val binding = AvatarElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvatarViewHolder(binding)
    }

    override fun getItemCount(): Int = avatars.size

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        val avatar = avatars[position]
        holder.bind(avatar)

        //Glide
        Glide.with(holder.itemView.context)
            .load(avatar.image)
            .into(holder.ivImagen)


        holder.itemView.setOnClickListener {
            onAvatarClicked(avatar)
        }


    }
}