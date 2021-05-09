package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_menu.*

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_menu, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var list = mutableListOf(
            type_two(1, "Alerts", R.drawable.icons_8_alarm),
            type_two(1, "Predictions", R.drawable.icons_8_left_and_right_arrows),
            type_two(1, "Saved elements", R.drawable.icons_8_pin),
            type_two(1, "Remove Ads", R.drawable.icons_8_no_entry),
            type_two(2, "Tools"),
            type_two(2, "Markets")
        )
        var adapter = Adapter_ViewType(list)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this.context)

    }
}