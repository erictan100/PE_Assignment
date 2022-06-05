package com.example.pe_assignment.initialFragment.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R
import com.example.pe_assignment.initialFragment.scan.QRScannerFragmentDirections


class MaMgameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_ma_mgame, container, false)
        val button_MaM = view.findViewById<ImageButton>(R.id.imageButton3)
        button_MaM.setOnClickListener{
            val action = MaMgameFragmentDirections.actionMaMgameFragmentToMixAndMatchFragment2()
            findNavController().navigate(action)
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MaMgameFragment()
    }
}