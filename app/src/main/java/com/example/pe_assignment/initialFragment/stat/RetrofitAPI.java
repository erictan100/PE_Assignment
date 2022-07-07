package com.example.pe_assignment.initialFragment.stat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface RetrofitAPI {
    @Headers({"X-RapidAPI-Key: 79ffa5cf02msh6527d22af231364p14cbbcjsncdb0925c279e","X-RapidAPI-Host: malaysia-covid19-data-live.p.rapidapi.com"})
    @GET("2022-05-20") //"https://malaysia-covid19-data-live.p.rapidapi.com/covid/getAllData/"
    Call<Statistics> getStatistics();
//    @GET("all") //https://disease.sh/v3/covid-19/all
//    Call<Statistics>getStatistics();
}

