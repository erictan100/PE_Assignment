package com.example.pe_assignment.initialFragment.stat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.pe_assignment.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StatisticFragment : Fragment() {

    var tv_active:TextView?=null
    var tv_confirm:TextView?=null
    var tv_recovered:TextView?=null
    var date1:TextView?=null
    var date2:TextView?=null
    var date3:TextView?=null
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

        tv_active = view.findViewById(R.id.value_active)
        tv_confirm = view.findViewById(R.id.value_confirmed)
        tv_recovered = view.findViewById(R.id.value_recovered)
        date1 = view.findViewById(R.id.date1)
        date2 = view.findViewById(R.id.date2)
        date3 = view.findViewById(R.id.date3)

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

        fetchApiDataUsingRetrofit();

        return view
    }



    private fun fetchApiDataUsingRetrofit() {
        val baseUrl = "https://malaysia-covid19-data-live.p.rapidapi.com/covid/getAllData/"
        val gson = GsonBuilder().setLenient().create()
        // Create a Retrofit builder and pass the gson in
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        // Implement the Retrofit Client interface function
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val statisticsCall = retrofitAPI.statistics
        val textView44 =view?.findViewById<TextView>(R.id.textView44)
        statisticsCall.enqueue(object : Callback<Statistics> {
            override fun onResponse(call: Call<Statistics?>, response: Response<Statistics?>) {
                if(response.isSuccessful){
                    Log.i("Success", "Good")
                    tv_active!!.text=response.body()!!.casesActive.toString()
                    tv_confirm!!.text=response.body()!!.casesNew.toString()
                    tv_recovered!!.text=response.body()!!.casesRecovered.toString()
                    date1!!.text=response.body()!!.date.toString()
                    date2!!.text=response.body()!!.date.toString()
                    date3!!.text=response.body()!!.date.toString()
                }
//                val statisticsResponse = response.body()!!
            }

            override fun onFailure(call: Call<Statistics>, t: Throwable) {
                Log.e("ERROR", t.message!!)
                Toast.makeText(activity, "Failed" + t.message, Toast.LENGTH_LONG)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}