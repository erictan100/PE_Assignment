package com.example.pe_assignment.initialFragment.game

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.pe_assignment.R

class GameFragment : Fragment() {

    var btn_myReward_game: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root: View =  inflater.inflate(R.layout.fragment_game, container, false)

        btn_myReward_game = root.findViewById<AppCompatButton>(R.id.btn_myReward_game)

        val gImage: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.gift_image,null)

        btn_myReward_game!!.setCompoundDrawablesWithIntrinsicBounds(gImage,null,null,null)

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameFragment()
    }
}

