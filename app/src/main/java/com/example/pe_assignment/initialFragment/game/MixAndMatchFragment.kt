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


class MixAndMatchFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_mix_and_match, container, false)
        val button_mm = view.findViewById<Button>(R.id.button6)
        button_mm.setOnClickListener{
            val action = MixAndMatchFragmentDirections.actionMixAndMatchFragment2ToMaMgameFragment()
            findNavController().navigate(action)
        }
        val button_back = view.findViewById<ImageButton>(R.id.imageButton2)
        button_back.setOnClickListener{
            val action2 = MixAndMatchFragmentDirections.actionMixAndMatchFragment2ToGameFragment()
            findNavController().navigate(action2)
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MixAndMatchFragment()
    }
}