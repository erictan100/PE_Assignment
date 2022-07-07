package com.example.pe_assignment.initialFragment.stat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitAPI2 {
    @Headers({"X-RapidAPI-Key: 79ffa5cf02msh6527d22af231364p14cbbcjsncdb0925c279e","X-RapidAPI-Host: malaysia-covid19-data-live.p.rapidapi.com"})
    @GET("total?date=2022-05-20")
    Call<Statistics2> getStatistics2();
}
