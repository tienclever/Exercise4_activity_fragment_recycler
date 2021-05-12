package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_onboarding2.*
import kotlinx.android.synthetic.main.layout_onboarding3.*

class Onboarding3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.layout_onboarding3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_onboarding_3.setOnClickListener {

            (activity as OnboardingActivity).start_Login()
        }

        btn_back_man3.setOnClickListener {
            (activity as OnboardingActivity).onClickPop()
        }

        textView13.setOnClickListener {
            (activity as OnboardingActivity).skip()
        }
    }
}