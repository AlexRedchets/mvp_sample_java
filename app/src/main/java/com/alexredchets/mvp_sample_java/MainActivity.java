package com.alexredchets.mvp_sample_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alexredchets.mvp_sample_java.currentWeather.CurrentWeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, new CurrentWeatherFragment(), "currentWeatherFragment")
                .commit();
    }
}
