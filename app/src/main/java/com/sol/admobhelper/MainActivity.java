package com.sol.admobhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.sol.admoblib.AdMobAppOpen;
import com.sol.admoblib.AdMobBanner;
import com.sol.admoblib.AdMobInterstitial;
import com.sol.admoblib.AdMobNative;
import com.sol.admoblib.AdMobReward;

public class MainActivity extends AppCompatActivity {

    private AdMobBanner adMobBanner;
    private AdMobNative adMobNative;
    private AdMobReward adMobReward;
    private AdMobAppOpen adMobAppOpen;
    private AdMobInterstitial adMobInterstitial;

    private AdView adView;
    private NativeExpressAdView nativeExpressAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAdViews();
        initButton();

        initAdMobBanner();
        initAdMobNative();
        initAdMobReward();
        initAdMobAppOpen();
        initAdMobInterstitial();
    }

    private void initAdMobBanner(){
        adMobBanner = new AdMobBanner(getApplicationContext(), adView);
    }

    private void initAdMobNative(){
        adMobNative = new AdMobNative(getApplicationContext(), nativeExpressAdView) {
            @Override
            public void onEnd() {

            }

            @Override
            public void onLoad() {
                adMobNative.show();
            }
        };
    }

    private void initAdMobReward(){
        adMobReward = new AdMobReward(this, getString(R.string.adReward)) {
            @Override
            public void onLoad() {
                adMobReward.show();
            }

            @Override
            public void onOpen() {
                Log.d(MainActivity.class.getSimpleName(), "on open reward ad");
            }

            @Override
            public void onClose() {
                Log.d(MainActivity.class.getSimpleName(), "on close reward ad");
            }

            @Override
            public void onFailedLoad(LoadAdError adError) {
                Log.d(MainActivity.class.getSimpleName(), "on failed load reward ad");
            }

            @Override
            public void onEarnedReward(@NonNull RewardItem reward) {
                Log.d(MainActivity.class.getSimpleName(), "earned reward " + reward.getType());
            }

            @Override
            public void onFailedEarnedReward(AdError adError) {
                Log.d(MainActivity.class.getSimpleName(), "on failed earned reward");
            }
        };
    }

    private void initAdMobInterstitial(){
        adMobInterstitial = new AdMobInterstitial(getApplicationContext(), getString(R.string.adInterstitial)) {
            @Override
            public void onLoad() {
                adMobInterstitial.show();
            }

            @Override
            public void onLoadFailed() {
                Log.d(MainActivity.class.getSimpleName(), "onLoadFailed");
            }

            @Override
            public void onOpened() {
                Log.d(MainActivity.class.getSimpleName(), "onOpened");
            }

            @Override
            public void onClosed() {
                Log.d(MainActivity.class.getSimpleName(), "onClosed");
            }
        };
    }

    private void initAdMobAppOpen(){
        adMobAppOpen = new AdMobAppOpen(this, getString(R.string.adOpen)) {
            @Override
            public void onLoad() {
                Log.d(MainActivity.class.getSimpleName(), "load app open ad");
                adMobAppOpen.show();
            }

            @Override
            public void onFailedLoad() {
                Log.d(MainActivity.class.getSimpleName(), "failed load app open ad");
            }
        };

    }

    private void initAdViews(){
        adView = findViewById(R.id.adViewBanner);
        nativeExpressAdView = findViewById(R.id.adViewNative);
    }

    private void initButton(){
        Button buttonBanner = findViewById(R.id.buttonBanner);
        Button buttonNative = findViewById(R.id.buttonNative);
        Button buttonReward = findViewById(R.id.buttonReward);
        Button buttonAppOpen = findViewById(R.id.buttonAppOpen);
        Button buttonInterstitial = findViewById(R.id.buttonInterstitial);

        buttonBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adMobBanner.load();
            }
        });

        buttonInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adMobInterstitial.load();
            }
        });

        buttonNative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adMobNative.load();
            }
        });

        buttonReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adMobReward.load();
            }
        });

        buttonAppOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adMobAppOpen.load();
            }
        });
    }
}