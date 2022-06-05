package com.example.pe_assignment.initialFragment.scan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R


class QRScannerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_q_r_scanner, container, false)

        val button_qr = view.findViewById<Button>(R.id.button5)
        button_qr.setOnClickListener{
            val action = QRScannerFragmentDirections.actionQRScannerFragmentToScannerCheckInFragment()
            findNavController().navigate(action)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QRScannerFragment()
    }
}