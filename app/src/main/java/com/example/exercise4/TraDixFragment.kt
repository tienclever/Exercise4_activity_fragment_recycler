package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_tradix.*

class TraDixFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_tradix, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var listTest = mutableListOf(
            Index(1, "DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(2, "TIENS", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(3, "MANH", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(4, "LINH", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(5, "DUC", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(6, "HANG", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(7, "HANH", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(8, "DUC", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(9, "HANG", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(10, "HANH", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)")
        )

        var adapter = AdapterHome(listTest)
        recycleview.adapter = adapter
        recycleview.layoutManager = LinearLayoutManager(this.context)
        btnLoadMore.visibility = View.VISIBLE;

        //line
        val layoutManager = LinearLayoutManager(
            this.context,
            RecyclerView.VERTICAL,
            false
        ).apply {
            recycleview.layoutManager = this
        }
        DividerItemDecoration(
            this.context, // context
            layoutManager.orientation
        ).apply {
            recycleview.addItemDecoration(this)
        }

        //deleteItem
        val itemTouchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    var pos = viewHolder.adapterPosition
                    listTest.removeAt(pos)
                    adapter.notifyDataSetChanged()
                }
            })
        itemTouchHelper.attachToRecyclerView(recycleview)
    }


}