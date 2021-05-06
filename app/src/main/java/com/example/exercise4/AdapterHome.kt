package com.example.exercise4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_recycler.view.*

class AdapterHome(
    var listIndex : List<Index>
) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {

    inner class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listIndex.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            txtName.text = listIndex[position].name
            txtAddress.text = listIndex[position].address
            txtBlue.text = listIndex[position].blue
            txtPlus.text = listIndex[position].plus
            txtTime.text = listIndex[position].time
        }
    }
}