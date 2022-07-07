package com.example.pe_assignment.initialFragment.scan;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryRepository {

    private final MutableLiveData<List<History>> allHistories = new MutableLiveData<>();

    // constructor -> initialize the properties of the class by default
    public HistoryRepository(Application application) {
        retrieveHistoryFromApi();
    }

    public MutableLiveData<List<History>> getAllHistories() {
        return allHistories;
    }

    public void insert(History history) {
        save_postData(history.getDate(),history.getTime(),history.getLocation());
    }

    private void save_postData(String date, String time, String location) {

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://62c6387ea361f7251296ee09.mockapi.io/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        HistoryAPI retrofitAPI = retrofit.create(HistoryAPI.class);

        // passing data from our text fields to our modal class.
        History history = new History(date, time, location);

        // calling a method to create a post and passing our model class.
        Call<History> call = retrofitAPI.createPost(history);

        // on below line we are executing our method.
        call.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {

                // we are getting response from our body
                // and passing it to our modal class.
                History responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.

                if(response.isSuccessful()){
                    String responseString = "Response Code : " + response.code() +
                            "\nDate : " + responseFromAPI.getDate() +
                            "\n" + "Time : " + responseFromAPI.getTime() +
                            //"\n" + "Status : " + responseFromAPI.getStatus() +
                            "\n" + "Location : " + responseFromAPI.getLocation();
                }
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
            }
        });
    }

    public void retrieveHistoryFromApi(){

        // Retrofit code to retrieve data from database
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://62c6387ea361f7251296ee09.mockapi.io/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        HistoryAPI retrofitAPI = retrofit.create(HistoryAPI.class);

        Call<List<History>> call = retrofitAPI.getHistories();

        call.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                if(response.isSuccessful()){
                    allHistories.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

}
