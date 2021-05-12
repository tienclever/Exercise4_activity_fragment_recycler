package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import kotlinx.android.synthetic.main.activity_email_.*

class EmailActivity : AppCompatActivity() {

    private val handlerThread : HandlerThread = HandlerThread("myThread")
    var number = 30
    lateinit var runable : Runnable
    lateinit var runabletwo : Runnable
    lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_)

        handlerThread.start()
        handler = Handler(this.handlerThread.looper)

        runable = Runnable {
            if (number > 0){
                number--
                runOnUiThread{
                    number_reset.text = number.toString()
                    if (number == 0){
                        val intent = Intent(this, Confirm_Activity::class.java)
                        startActivity(intent)
                    }
                }
                handler.postDelayed(runable,1000)
            }
        }
        runabletwo = Runnable {
            number = 30
            runOnUiThread {
                number_reset.text = number.toString()
            }
        }

        handler.post(runable)

        button.setOnClickListener {
            handler.removeCallbacks(runable)
            handler.postDelayed(runabletwo,50)
            handler.post(runable)
        }
    }
}