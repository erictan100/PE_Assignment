package com.example.pe_assignment.initialFragment.scan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.LoginActivity.scanName
import com.example.pe_assignment.R
import com.example.pe_assignment.SelfAssessmentActivity.riskstatus
import com.google.zxing.integration.android.IntentIntegrator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class ScanFragment : Fragment() {

    var responseString: String? = null
    var adapter: HistoryListAdapter? = null
    private val historyList = LinkedList<History>()

    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_scan, container, false)

        val textView = view.findViewById<TextView>(R.id.textView14)
        textView.setText("Status: " + riskstatus)

        val scanname = view.findViewById<TextView>(R.id.textView13)
        scanname.setText(scanName)

        val button_scan = view.findViewById<Button>(R.id.button3)
        button_scan.setOnClickListener{
            val action = ScanFragmentDirections.actionScanFragmentToHistoryActivity()
            findNavController().navigate(action)
        }

        //tv_qr_readTxt = findViewById(R.id.tv_qr_readTxt);

        // Set up recycler view.
//        recyclerView = findViewById(R.id.recyclerview);
//        adapter = new HistoryListAdapter(new HistoryListAdapter.HistoryDiff());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ScanActivity.this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        //mainViewModelFactory = new MainViewModelFactory((Application) this.getApplicationContext());
        mainViewModel = ViewModelProvider(this@ScanFragment).get(MainViewModel::class.java)

        mainViewModel!!.allHistories.observe(
            viewLifecycleOwner
        ) { histories: List<History?>? ->

            // Store the scanner text to array list
            val historyListSize = historyList.size
            // Update the cached copy of the histories in the adapter.
            adapter?.submitList(histories)
        }

        val button_scan2 = view.findViewById<Button>(R.id.button4)
        button_scan2.setOnClickListener{
//            fun onClick(view: View?) {

                // Under ZXing library for QRcode scan
                val integrator = IntentIntegrator(activity)
                //set the properties of the scan
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                integrator.setPrompt("Scan")
                integrator.setCameraId(0)
                integrator.setBeepEnabled(true)
                integrator.setBarcodeImageEnabled(false)
                integrator.setOrientationLocked(true)
                integrator.initiateScan()
//            }
//            val action2 = ScanFragmentDirections.actionScanFragmentToQRScannerFragment()
//            findNavController().navigate(action2)
        }

        retrieveHistoryFromApi()
        return view
    }

    private fun retrieveHistoryFromApi() {
        val baseurl = "https://62c6387ea361f7251296ee09.mockapi.io/"

        // Retrofit code to retrieve data from database
        val retrofit = Retrofit.Builder()
            .baseUrl(baseurl) // as we are sending data in json format so
            // we have to add Gson converter factory
            .addConverterFactory(GsonConverterFactory.create()) // at last we are building our retrofit builder.
            .build()

        // below line is to create an instance for our retrofit api class.
        val retrofitAPI = retrofit.create(HistoryAPI::class.java)
        val call = retrofitAPI.histories
        call.enqueue(object : Callback<List<History?>> {
            override fun onResponse(call: Call<List<History?>>, response: Response<List<History?>>) {
                if (response.isSuccessful) {
//                    historyList = response.body() as ArrayList<History>
//                    adapter?.submitList(historyList)
                }
            }

            override fun onFailure(call: Call<List<History?>>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Log.e("Scan*******", "Cancelled scan")
            } else {
                Log.e("Scan", "Scanned")

                //tv_qr_readTxt.setText(result.getContents());
                Toast.makeText(activity, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()

                // Split the result here
                val scanResult = result.contents
                //String[] item = scanResult.split(";");
                val current_date = LocalDate.now().toString()
                val current_time = LocalTime.now().toString()
                val history= History(current_date, current_time, scanResult)

                mainViewModel?.insert(history)

                // Store the scanner text to array list
                val historyListSize = historyList.size

                historyList.addLast(history)
                adapter!!.submitList(historyList)

            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data)
        }
    }



    companion object {

        @JvmStatic
        fun newInstance() = ScanFragment()
    }
}

