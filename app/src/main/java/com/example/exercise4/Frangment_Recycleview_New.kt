package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_news.*

class Frangment_Recycleview_New : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var list = mutableListOf(
            news(R.drawable.anhdienthoai, "ALT -3,87%", "ATLANTIA", "3 Sept 2020"),
            news(R.drawable.dienthoainuoc, "HKD -2,13%", "XIAOMI", "2 Sept 2020"),
            news(R.drawable.anhdienthoai, "AAPL -0,91%", "APPLE", "1 Sept 2020")
        )
        var adapter = Adapter_news(list)
        rv_news.adapter = adapter
        rv_news.layoutManager = LinearLayoutManager(this.context)
    }
}