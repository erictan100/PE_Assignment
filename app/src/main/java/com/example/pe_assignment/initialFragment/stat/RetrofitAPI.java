package com.example.pe_assignment.initialFragment.stat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface RetrofitAPI {
    @Headers({"X-RapidAPI-Key: 908e5176acmshc0c79425c5e762bp11b927jsn358c73371654","X-RapidAPI-Host: malaysia-covid19-data-live.p.rapidapi.com"})
    @GET("2022-05-20") //"https://malaysia-covid19-data-live.p.rapidapi.com/covid/getAllData/"
    Call<Statistics> getStatistics();
//    @GET("all") //https://disease.sh/v3/covid-19/all
//    Call<Statistics>getStatistics();
}

