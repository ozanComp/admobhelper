package com.sol.admobhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdView;
import com.sol.admoblib.AdMobLib;

public class MainActivity extends AppCompatActivity {

    AdView adView;
    Button buttonBanner, buttonInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = findViewById(R.id.adView);
        buttonBanner = findViewById(R.id.buttonBanner);
        buttonInterstitial = findViewById(R.id.buttonInterstitial);

        buttonBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdMobLib.instance(getApplicationContext()).loadBanner(adView);
            }
        });

        buttonInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdMobLib.instance(getApplicationContext()).loadInterstitial(getString(R.string.adInterstitial));
            }
        });
    }
}