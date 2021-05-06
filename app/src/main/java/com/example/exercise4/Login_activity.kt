package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        initFragment()
    }

    internal fun initFragment() {
        val firstFragment = Login_Fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.container_login, firstFragment)
    }

    internal fun initFragment_signUp(){
        val secondFragment = SignUp_Fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("ok")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.container_login, secondFragment)
    }

    internal fun popFragment(){
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }

    internal fun start_Email(){
        val intent = Intent(this, EmailActivity::class.java)
        startActivity(intent)
    }

}