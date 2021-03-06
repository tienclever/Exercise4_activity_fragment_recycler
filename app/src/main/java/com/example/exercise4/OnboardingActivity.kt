package com.example.exercise4

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {

    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_onboarding)

        init_one_fragment()
    }

    private fun init_one_fragment() {

        val firstFragment = Onboarding1()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.replace(R.id.container_body, firstFragment)
        fragmentTransaction.addToBackStack("one - ${count++}")
    }

    internal fun init_two_fragment() {

        val twoFrag = Onboarding2()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.addToBackStack("two - ${count++}")
        fragmentTransaction.replace(R.id.container_body, twoFrag)
    }

    internal fun init_three_fragment() {

        val twoFrag = Onboarding3()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.commit()
        fragmentTransaction.addToBackStack("three - ${count++}")
        fragmentTransaction.replace(R.id.container_body, twoFrag)
    }

    internal fun start_Login() {
        val intent = Intent(this, Login_activity::class.java)
        startActivity(intent)
    }

    fun onClickPop() {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
        count--
    }

    fun showDialog(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Thoát app")
        builder.setMessage("bạn có muốn thóat")
        builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->
            finish()
        })
        builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        count--
        if (count == 0) {
            showDialog()
        }else{
            super.onBackPressed()
        }
    }

    fun skip(){
        val intent = Intent(this, Login_activity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}