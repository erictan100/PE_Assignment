package com.example.pe_assignment.initialFragment.scan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface HistoryAPI {
    @POST("History")  //insert new data
        //on below line we are creating a method to post our data.
    Call<History> createPost(@Body History history);

    @GET("History/{id}")  // get one history item by ID
    Call<History> getHistory(@Path("id") int id, @Body History history);

    @GET("History")  // get all history items
    Call<List<History>> getHistories();

    @PUT("History/{id}")
    Call<History> updateHistory(@Path("id") int id);

    @DELETE("History/{id}")
    Call<History> deleteHistory(@Path("id") int id);
}
