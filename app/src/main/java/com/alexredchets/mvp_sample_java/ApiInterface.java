package com.alexredchets.mvp_sample_java;

import com.alexredchets.mvp_sample_java.currentWeather.model.WeatherCurrent;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?")
    Observable<WeatherCurrent> getCurrentWeather(
            @Query("lat") String latitude,
            @Query("lon") String longitude,
            @Query("units") String units,
            @Query("appid") String appid
    );
}
