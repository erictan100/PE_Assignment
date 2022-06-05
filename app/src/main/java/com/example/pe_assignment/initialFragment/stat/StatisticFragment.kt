package com.example.pe_assignment.initialFragment.stat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pe_assignment.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class StatisticFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var pagerAdapter: FragmentStateAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_statistic, container, false)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager2)

        pagerAdapter = ViewPagerAdapter(this)
        viewPager2.adapter = pagerAdapter

        val titles = arrayOf("Global", "States")

        TabLayoutMediator(
            tabLayout,
            viewPager2
        ){
                tab: TabLayout.Tab, position:Int->
            tab.text=titles[position]
        }.attach()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}