package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm_.*

class Confirm_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_)

        btnChuyen.setOnClickListener {
            val intent = Intent(this, Login_activity::class.java).apply {
                putExtra("key", "123")
            }
            startActivity(intent)
            finish()
        }
    }
}