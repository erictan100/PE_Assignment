package com.example.pe_assignment.initialFragment.stat

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pe_assignment.MainActivity

class ViewPagerAdapter(fa:StatisticFragment?):FragmentStateAdapter(fa!!) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                GlobalStatisticsFragment.newInstance()
            }
            1 ->{
                StateStatisticsFragment.newInstance()
            }
            else -> GlobalStatisticsFragment.newInstance()
        }
    }
}