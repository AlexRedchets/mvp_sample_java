package com.alexredchets.mvp_sample_java.currentWeather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.alexredchets.mvp_sample_java.currentWeather.model.WeatherCurrent;

public class CurrentWeatherFragment extends Fragment implements CurrentWeatherPresenter.View {

    private CurrentWeatherPresenter.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new CurrentWeatherPresenterImpl();
        presenter.setView(this);
        presenter.loadData(getContext());
    }

    @Override
    public void onDataReceived(WeatherCurrent data) {
        Toast.makeText(getContext(), "Data received", Toast.LENGTH_SHORT).show();
    }
}
