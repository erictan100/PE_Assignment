package com.example.pe_assignment.initialFragment.scan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R

class ScanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_scan, container, false)

        val button_scan = view.findViewById<Button>(R.id.button3)
        button_scan.setOnClickListener{
            val action = ScanFragmentDirections.actionScanFragmentToHistoryFragment()
            findNavController().navigate(action)
        }

        val button_scan2 = view.findViewById<Button>(R.id.button4)
        button_scan2.setOnClickListener{
            val action2 = ScanFragmentDirections.actionScanFragmentToQRScannerFragment()
            findNavController().navigate(action2)
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = ScanFragment()
    }
}