package com.example.pe_assignment.initialFragment.stat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.pe_assignment.R
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Console
import java.lang.Math.log
import java.lang.StrictMath.log


class GlobalStatisticsFragment : Fragment() {

    var Jan_y1:String ="123"
    var Jan_y2:String ="123"
    var Jan_y3:String = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setBarChartValues()

        return inflater.inflate(R.layout.fragment_global_statistics, container, false)
    }

    fun setBarChartValues(){
        // x axis values
        val xvalues = ArrayList<String>()
        xvalues.add("JAN")
        xvalues.add("FEB")
        xvalues.add("MAR")
        xvalues.add("APR")
        xvalues.add("MAY")
        xvalues.add("JUN")

        fetchApiDataUsingRetrofit()

        // y axis value or bar data
        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(Jan_y1.toFloat(), 0))
        barEntries.add(BarEntry(Jan_y2.toFloat(), 0))
        barEntries.add(BarEntry(Jan_y3.toFloat(), 0))

    }
    private fun fetchApiDataUsingRetrofit() {
        val date = "2022-05-20"
        val baseUrl = "https://covid-19-statistics.p.rapidapi.com/reports/"
        val gson = GsonBuilder().setLenient().create()
        // Create a Retrofit builder and pass the gson in
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        // Implement the Retrofit Client interface function
        val retrofitAPI = retrofit.create(RetrofitAPI2::class.java)
        val statisticsCall = retrofitAPI.statistics2
        statisticsCall.enqueue(object : Callback<Statistics2> {
            override fun onResponse(call: Call<Statistics2>, response: Response<Statistics2>) {
                if(response.isSuccessful) {
                    var test: Int = response.body()!!.data.active
                    Jan_y1 = response.body()!!.data.confirmed.toString()
                    Jan_y2 = response.body()!!.data.deaths.toString()
                    Jan_y3 = response.body()!!.data.active.toString()
                    Log.e("value", test.toString())
                    Log.e("SSS", "FFF")
                }
            }

            override fun onFailure(call: Call<Statistics2>, t: Throwable) {
                Log.e("ERROR", t.message!!)
                Toast.makeText(activity, "Failed" + t.message, Toast.LENGTH_LONG)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GlobalStatisticsFragment()
    }
}