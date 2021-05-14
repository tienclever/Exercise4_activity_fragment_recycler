package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_activity.*

class Login_activity : AppCompatActivity() {

    private lateinit var firstFragment: Login_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        initFragment()
    }

    internal fun initFragment() {
        firstFragment = Login_Fragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.container_login, firstFragment)
    }

    internal fun initFragment_signUp() {
        val secondFragment = SignUp_Fragment(
            object : SignUp_Fragment.IsentDataListener {
                override fun sentData(a: String, b: String) {
                    if (::firstFragment.isInitialized) {
                        firstFragment.setTextCallBack(a, b)
                    }
                }
            })
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("ok")
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.container_login, secondFragment)
    }

    internal fun popFragment() {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }

    internal fun start_Email() {
        val intent = Intent(this, EmailActivity::class.java)
        startActivity(intent)
    }

    internal fun start_Home() {
        val intent = Intent(this, Home_Activity::class.java)
        startActivity(intent)
    }

    internal fun start_login() {
        val intent = Intent(this, Login_activity::class.java)
        startActivity(intent)
    }
}