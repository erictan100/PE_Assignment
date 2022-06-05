package com.example.pe_assignment.initialFragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R
import com.example.pe_assignment.initialFragment.game.MixAndMatchFragmentDirections


class FAQFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_f_a_q, container, false)

        val button_submit = view.findViewById<Button>(R.id.faq_submit_btn)
        button_submit.setOnClickListener{
            val action = FAQFragmentDirections.actionFAQFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FAQFragment()
    }
}