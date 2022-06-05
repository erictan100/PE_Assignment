package com.example.pe_assignment.initialFragment.game

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.MyRewardActivity
import com.example.pe_assignment.R

class GameFragment : Fragment() {

    var btn_myReward_game: AppCompatButton? = null
    var quiz_game_btn: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root: View =  inflater.inflate(R.layout.fragment_game, container, false)

        btn_myReward_game = root.findViewById<AppCompatButton>(R.id.btn_myReward_game)

        val gImage: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.gift_image,null)

        btn_myReward_game!!.setCompoundDrawablesWithIntrinsicBounds(gImage,null,null,null)
        btn_myReward_game!!.setOnClickListener{
            val intent = Intent (activity, MyRewardActivity::class.java)
            startActivity(intent)
        }


        quiz_game_btn = root.findViewById<ImageButton>(R.id.quiz_game_btn)
        quiz_game_btn!!.setOnClickListener{
           val intent = Intent (activity, QuizMenuActivity::class.java)
           startActivity(intent)
        }

        val mixGameBtn = root.findViewById<ImageButton>(R.id.mix_game_btn)
        mixGameBtn.setOnClickListener{
            val action = GameFragmentDirections.actionGameFragmentToMixAndMatchFragment2()
            findNavController().navigate(action)
        }

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameFragment()
    }
}

