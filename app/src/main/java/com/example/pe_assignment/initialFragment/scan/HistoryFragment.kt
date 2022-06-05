package com.example.pe_assignment.initialFragment.scan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R

class HistoryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_history, container, false)

        val back_btn = view.findViewById<ImageButton>(R.id.imageButton)
        back_btn.setOnClickListener{
            val action = HistoryFragmentDirections.actionHistoryFragmentToScanFragment()
            findNavController().navigate(action)
        }
        return view
    }

    companion object {

        @JvmStatic fun newInstance() =
                HistoryFragment()
    }
}