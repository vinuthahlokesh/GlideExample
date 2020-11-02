package com.example.glideexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val context:Context,val doglist:List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImage: ImageView = itemView.findViewById(R.id.dogimageview)

    }
    private val imageWidthPixels = 1100;
    private val imageHeightPixels = 4000;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        Glide.with(context)
            .load(doglist[position])
            .override(imageWidthPixels, imageHeightPixels)
            .into(holder.dogImage)

    }

    override fun getItemCount(): Int {
        return doglist.size
    }
}