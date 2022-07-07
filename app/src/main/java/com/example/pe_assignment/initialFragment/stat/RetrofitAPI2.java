package com.example.pe_assignment.initialFragment.stat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitAPI2 {
    @Headers({"X-RapidAPI-Key: 908e5176acmshc0c79425c5e762bp11b927jsn358c73371654","X-RapidAPI-Host: malaysia-covid19-data-live.p.rapidapi.com"})
    @GET("total?date=2022-05-20")
    Call<Statistics2> getStatistics2();
}
