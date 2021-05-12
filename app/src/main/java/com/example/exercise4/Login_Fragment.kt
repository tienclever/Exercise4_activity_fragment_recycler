package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_login_fragment.*
import kotlinx.android.synthetic.main.layout_signup_fragment.*

class Login_Fragment : Fragment() {

    var bien1 :String =""
    var bien2 :String =""
    var x = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        txt_signUp.setOnClickListener {
            (activity as Login_activity).initFragment_signUp()
        }

        btn_login.setOnClickListener {
            if (etLogin1.text.toString().isEmpty() || etLogin2.text.toString().isEmpty()){
                Toast.makeText(this.context, "bạn nhập thiếu thông tin!!", Toast.LENGTH_LONG).show()
            }else{

                (activity as Login_activity).start_Home()
            }
        }

        forgot_login.setOnClickListener {
            (activity as Login_activity).start_Email()
            x=0
        }

    }

    override fun onResume() {
        if (x== 1){
            etLogin1.setText(bien1)
            etLogin2.setText(bien2)
        }else{
            etLogin1.setText(bien1)
            etLogin2.setText("123")
        }
        super.onResume()
    }

    fun setTextCallBack(a: String, b: String) {
        bien1 = a
        bien2 = b
    }
}