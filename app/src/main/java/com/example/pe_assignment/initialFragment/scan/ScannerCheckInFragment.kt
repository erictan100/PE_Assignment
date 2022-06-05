package com.example.pe_assignment.initialFragment.scan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ScannerCheckInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_scanner_check_in, container, false)

        val button_checkin = view.findViewById<Button>(R.id.button7)
        button_checkin.setOnClickListener{
            val action = ScannerCheckInFragmentDirections.actionScannerCheckInFragmentToScanFragment()
            findNavController().navigate(action)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScannerCheckInFragment()
    }
}