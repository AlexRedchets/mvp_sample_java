package com.alexredchets.mvp_sample_java.currentWeather;

import android.content.Context;

import com.alexredchets.mvp_sample_java.currentWeather.model.WeatherCurrent;

public class CurrentWeatherPresenter {

    interface Presenter {
        void setView(CurrentWeatherPresenter.View view);
        void loadData(Context context);
    }

    interface View {
        void onDataReceived(WeatherCurrent data);
    }
}
