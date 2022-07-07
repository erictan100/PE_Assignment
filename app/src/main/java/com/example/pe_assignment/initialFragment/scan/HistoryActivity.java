package com.example.pe_assignment.initialFragment.scan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pe_assignment.MainActivity;
import com.example.pe_assignment.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton imageButton;
    HistoryListAdapter adapter;
    private final LinkedList<History> historyList = new LinkedList<>();

    MainViewModel mainViewModel;
    //MainViewModelFactory mainViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_history);

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Set up recycler view.
        recyclerView = findViewById(R.id.recycleView_history);
        adapter = new HistoryListAdapter(new HistoryListAdapter.HistoryDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        //mainViewModelFactory = new MainViewModelFactory((Application) this.getApplicationContext());
        mainViewModel = new ViewModelProvider(HistoryActivity.this).get(MainViewModel.class);

        mainViewModel.getAllHistories().observe(this, histories -> {

            // Store the scanner text to array list
            int historyListSize = historyList.size();
            // Update the cached copy of the histories in the adapter.
            adapter.submitList(histories);
            recyclerView.getAdapter().notifyDataSetChanged();
            // Scroll to the bottom.
            recyclerView.smoothScrollToPosition(historyListSize);
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.e("Scan*******", "Cancelled scan");
            } else {
                Log.e("Scan", "Scanned");

                //tv_qr_readTxt.setText(result.getContents());
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                // Split the result here
                String scanResult = result.getContents();
                //String[] item = scanResult.split(";");

                String current_date = java.time.LocalDate.now().toString();
                String current_time = java.time.LocalTime.now().toString();

                History history = new History(current_date,current_time,scanResult);
                //historyViewModel.insert(history);
                //save_postData(current_date,current_time,item[0],item[1]);
                mainViewModel.insert(history);

                // Store the scanner text to array list
                int historyListSize = historyList.size();
                // Add a new word to the historyList.
                historyList.addLast(history);
                adapter.submitList(historyList);
                recyclerView.getAdapter().notifyDataSetChanged();
                // Scroll to the bottom.
                recyclerView.smoothScrollToPosition(historyListSize);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
