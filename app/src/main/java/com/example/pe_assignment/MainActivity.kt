package com.example.pe_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationController = this.findNavController(R.id.navigation_fragment_main)
        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        navigationView.setupWithNavController(navigationController)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment, R.id.statisticFragment, R.id.scanFragment, R.id.gameFragment, R.id.profileFragment
//            )
//        )

        navigationView.background = null
        navigationView.menu.getItem(2).isEnabled = false

//        setupActionBarWithNavController(navigationController), appBarConfiguration)
//        navigationView.setupWithNavController(navigationController)

        val floating_btn = findViewById<FloatingActionButton>(R.id.floating_btn)
        floating_btn.setOnClickListener{
            navigationController.navigate(R.id.scanFragment)
        }

        val btn_setting = findViewById<AppCompatImageButton>(R.id.btn_setting)
        btn_setting.setOnClickListener{
            val intent = Intent (this, SettingActivity::class.java)
            startActivity(intent)
        }

    }
}