package com.example.exercise4

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_home_.*


class Home_Activity : AppCompatActivity() {

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)

        init_one_fragment()
        btnIncrease.setBackgroundResource(R.drawable.increase)
        imageView11.visibility = View.VISIBLE;

        btnIncrease.setOnClickListener {
            init_one_fragment()
            btnIncrease.setBackgroundResource(R.drawable.increase)
            imageView11.visibility = View.VISIBLE
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.visibility = View.INVISIBLE
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.visibility = View.INVISIBLE
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.visibility = View.INVISIBLE
            var buttonDrawable2: Drawable? = btnNew.background
            buttonDrawable2?.setTint(Color.BLACK)
            var buttonDrawable3: Drawable? = btnCustomer.background
            buttonDrawable3?.setTint(Color.BLACK)

        }
        btnChart.setOnClickListener {
            init_two_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.visibility = View.INVISIBLE
            btnChart.setBackgroundResource(R.drawable.chart)
            imageView12.visibility = View.VISIBLE
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.visibility = View.INVISIBLE
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.visibility = View.INVISIBLE
            var buttonDrawable2: Drawable? = btnNew.background
            buttonDrawable2?.setTint(Color.BLACK)
            var buttonDrawable3: Drawable? = btnCustomer.background
            buttonDrawable3?.setTint(Color.BLACK)

        }
        btnNew.setOnClickListener {
            init_three_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.visibility = View.INVISIBLE
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.visibility = View.INVISIBLE
            btnNew.setBackgroundResource(R.drawable.icons_8_news)

            //setTint
            var buttonDrawable1: Drawable? = btnNew.background
            buttonDrawable1 = DrawableCompat.wrap(buttonDrawable1!!)
            DrawableCompat.setTint(buttonDrawable1, Color.WHITE);
            btnNew.background = buttonDrawable1

            var buttonDrawable3: Drawable? = btnCustomer.background
            buttonDrawable3?.setTint(Color.BLACK)

            imageView13.visibility = View.VISIBLE
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)
            imageView14.visibility = View.INVISIBLE
        }
        btnCustomer.setOnClickListener {
            init_four_fragment()
            btnIncrease.setBackgroundResource(R.drawable.icons_8_increase)
            imageView11.visibility = View.INVISIBLE
            btnChart.setBackgroundResource(R.drawable.icons_8_chart)
            imageView12.visibility = View.INVISIBLE
            btnNew.setBackgroundResource(R.drawable.icons_8_news)
            imageView13.visibility = View.INVISIBLE
            btnCustomer.setBackgroundResource(R.drawable.icons_8_customer)

            var buttonDrawable2: Drawable? = btnNew.background
            buttonDrawable2?.setTint(Color.BLACK)

            var buttonDrawable3: Drawable? = btnCustomer.background
            buttonDrawable3 = DrawableCompat.wrap(buttonDrawable3!!)
            DrawableCompat.setTint(buttonDrawable3, Color.WHITE);
            btnCustomer.background = buttonDrawable3

            imageView14.visibility = View.VISIBLE
        }
    }

    private fun init_one_fragment() {
        val oneFragment = TraDixFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack("add1 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, oneFragment)
    }

    private fun init_two_fragment() {
        val twoFragment = CoinFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack("add2 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, twoFragment)
    }

    private fun init_three_fragment() {
        val threeFragment = NewFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack("add3 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, threeFragment)
    }

    private fun init_four_fragment() {
        val fourtFragment = MenuFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.addToBackStack("add4 ${number++}")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_layout, fourtFragment)
    }

    fun DeleteFragment() {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }

    override fun onBackPressed() {
//        finish()
//        var buttonDrawable2: Drawable? = btnNew.background
//        buttonDrawable2?.setTint(Color.BLACK)
        var buttonDrawable3: Drawable? = btnCustomer.background
        buttonDrawable3?.setTint(Color.BLACK)
        super.onBackPressed()
    }

    internal fun init() {
        val oneFragment = Recycler_Fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_test, oneFragment)
    }

    internal fun init2() {
        val oneFragment = Fragment_Shares()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.frame_test, oneFragment)
    }

    internal fun background() {
        constraintLayout2.setBackgroundColor(Color.BLUE)
    }

    internal fun background2() {
        constraintLayout2.setBackgroundColor(Color.WHITE)
    }

    internal fun initFrangmentRecyclerNew() {
        val frangmentRecycler = Frangment_Recycleview_New()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.contener_news, frangmentRecycler)
        fragmentTransition.commit()
    }

    internal fun initTest() {
        val frangmentDetail = Fragment_Detail()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout, frangmentDetail)
        fragmentTransition.addToBackStack("add4")
        fragmentTransition.commit()
    }

}