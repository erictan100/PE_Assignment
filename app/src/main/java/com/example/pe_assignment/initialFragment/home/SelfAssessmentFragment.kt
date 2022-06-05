package com.example.pe_assignment.initialFragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R


class SelfAssessmentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_self_assessment, container, false)

        val button_submit = view.findViewById<Button>(R.id.self_assessment_submit)
        button_submit.setOnClickListener{
            val action = SelfAssessmentFragmentDirections.actionSelfAssessmentFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelfAssessmentFragment()
    }
}