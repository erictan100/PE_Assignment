package com.example.pe_assignment.initialFragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)

        val button_home = view.findViewById<Button>(R.id.button)
        button_home.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToSelfAssessmentFragment()
            findNavController().navigate(action)
        }

        val button_home2 = view.findViewById<Button>(R.id.button2)
        button_home2.setOnClickListener{
            val action2 = HomeFragmentDirections.actionHomeFragmentToFAQFragment()
            findNavController().navigate(action2)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}