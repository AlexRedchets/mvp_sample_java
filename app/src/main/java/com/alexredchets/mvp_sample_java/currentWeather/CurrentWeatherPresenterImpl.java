package com.alexredchets.mvp_sample_java.currentWeather;

import android.content.Context;
import android.widget.Toast;

import com.alexredchets.mvp_sample_java.ApiClient;
import com.alexredchets.mvp_sample_java.ApiInterface;
import com.alexredchets.mvp_sample_java.currentWeather.model.WeatherCurrent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentWeatherPresenterImpl implements CurrentWeatherPresenter.Presenter {

    private CurrentWeatherPresenter.View view;

    @Override
    public void setView(CurrentWeatherPresenter.View view) {
        this.view = view;
    }

    @Override
    public void loadData(final Context context) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<WeatherCurrent> call = apiInterface.getCurrentWeather(
                "43.811217",
                "-79.542002",
                "metric",
                "d73975775ce9c90c9b05799d119ef5e9");

        call.enqueue(new Callback<WeatherCurrent>() {

            @Override
            public void onResponse(Call<WeatherCurrent> call, Response<WeatherCurrent> response) {
                view.onDataReceived(response.body());
            }

            @Override
            public void onFailure(Call<WeatherCurrent> call, Throwable t) {
                Toast.makeText(context, "Error. Try later.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
