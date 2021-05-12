package com.example.exercise4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_news.view.*

class Adapter_news(var list: List<news>) : RecyclerView.Adapter<Adapter_news.ViewHolder>() {

    inner class ViewHolder(item : View) : RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_news,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            image.setImageResource(list[position].image)
            text.text = list[position].text
            tint.text = list[position].tint
            time.text = list[position].time
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}