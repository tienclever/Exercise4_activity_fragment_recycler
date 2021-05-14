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
import kotlinx.android.synthetic.main.layout_recycler_fragment.*

class Recycler_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_recycler_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var listTest = mutableListOf(
            Index(1, "DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(2, "FTSE100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(3, "IBAX35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(4, "DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(5, "DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(6, "FISE100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(7, "IBEX35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Index(8, "DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)")
        )

        var adapter = AdapterHome(listTest)
        recycleview.adapter = adapter
        recycleview.layoutManager = LinearLayoutManager(this.context)

        btnLoadMore.setOnClickListener {
            listTest.add(Index(11, "DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(12, "FISE100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(13, "IBEX35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(14, "DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(15, "IBAX35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(16, "DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(17, "DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(18, "FISE100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(19, "IBEX35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            listTest.add(Index(20, "DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
            adapter.notifyDataSetChanged()
        }

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