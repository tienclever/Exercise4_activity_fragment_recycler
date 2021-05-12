package com.example.exercise4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_three.view.*
import kotlinx.android.synthetic.main.row_two.view.*

class Adapter_ViewType(var listTwo: List<type_two>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TYPE_1 = 1
    }

    inner class ViewHolderOne(val view: View) : RecyclerView.ViewHolder(view) {
    }

    inner class ViewHolderTwo(val view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemViewType(position: Int): Int {
        return when (listTwo[position].type) {
            TYPE_1 -> 1
            else -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 ->
                ViewHolderOne(
                    LayoutInflater.from(parent.context).inflate(R.layout.row_two, parent, false)
                )
            else ->
                ViewHolderTwo(
                    LayoutInflater.from(parent.context).inflate(R.layout.row_three, parent, false)
                )

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderOne -> {
                holder.itemView.apply {
                    txt_name.text = listTwo[position].name
                    img.setImageResource(listTwo[position].icon)
                }
            }
            is ViewHolderTwo -> {
                holder.itemView.apply {
                    btnOne.text = listTwo[position].name
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listTwo.size
    }
}