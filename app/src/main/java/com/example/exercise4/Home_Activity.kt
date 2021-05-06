package com.example.exercise4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_.*

class Home_Activity : AppCompatActivity() {

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)

        init_one_fragment()
        btnIncrease.setBackgroundResource(R.drawable.increase)
        imageView11.setVisibility(View.VISIBLE);

        btnIncrease.setOnClickListener {
            Delete()
            init_one_fragment()
            btnIncrease.setBackgroundResource(R.drawable.increase)
            imageView11.setVisibility(View.VISIBLE)
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.setVisibility(View.INVISIBLE)
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.setVisibility(View.INVISIBLE)
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.setVisibility(View.INVISIBLE)
        }
        btnChart.setOnClickListener {
            Delete()
            init_two_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.setVisibility(View.INVISIBLE)
            btnChart.setBackgroundResource(R.drawable.chart)
            imageView12.setVisibility(View.VISIBLE)
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.setVisibility(View.INVISIBLE)
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.setVisibility(View.INVISIBLE)
        }
        btnNew.setOnClickListener {
            Delete()
            init_three_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.setVisibility(View.INVISIBLE)
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.setVisibility(View.INVISIBLE)
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.setVisibility(View.VISIBLE)
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.setVisibility(View.INVISIBLE)
        }
        btnCustomer.setOnClickListener {
            Delete()
            init_four_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.setVisibility(View.INVISIBLE)
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.setVisibility(View.INVISIBLE)
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.setVisibility(View.INVISIBLE)
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.setVisibility(View.VISIBLE)
        }
    }

    private fun init_one_fragment() {
        val oneFragment = TraDixFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("add1 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, oneFragment)
    }
    private fun init_two_fragment() {
        val twoFragment = CoinFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("add2 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, twoFragment)
    }
    private fun init_three_fragment() {
        val threeFragment = NewFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("add3 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, threeFragment)
    }
    private fun init_four_fragment() {
        val fourtFragment = MenuFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("add4 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, fourtFragment)
    }
    fun Delete(){
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }
}