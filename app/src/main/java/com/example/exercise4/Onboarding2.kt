package com.example.exercise4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_onboarding2.*

class Onboarding2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.layout_onboarding2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {

        }
        btn_onboarding_2.setOnClickListener {
            (activity as OnboardingActivity).init_three_fragment()
        }

        btn_back_man2.setOnClickListener {
            (activity as OnboardingActivity).onClickPop()
        }
    }

}