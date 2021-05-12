package com.example.exercise4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_signup_fragment.*


class SignUp_Fragment(val callback: IsentDataListener) : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_signup_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn_signUp.setOnClickListener {
            (activity as Login_activity).popFragment()
            var x = et1.text.toString()
            var y = et2.text.toString()

            callback.sentData(x,y)
        }

        txtforGotPasswork.setOnClickListener {
            (activity as Login_activity).start_Email()
        }

    }

    interface IsentDataListener {
        fun sentData(a: String, b: String)
    }

}