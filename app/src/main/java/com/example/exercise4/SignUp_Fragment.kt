package com.example.exercise4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_signup_fragment.*

class SignUp_Fragment : Fragment() {

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

            var intent = Intent()
            intent.putExtra("key1", et1.text)
            intent.putExtra("key2", et2.text)
            (activity as Login_activity).start_login()
            (activity as Login_activity).popFragment()
        }

        txtforGotPasswork.setOnClickListener {
            (activity as Login_activity).start_Email()
            (activity as Login_activity).popFragment()
        }

    }
}