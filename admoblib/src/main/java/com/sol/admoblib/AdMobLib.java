package com.sol.admoblib;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AdMobLib {
    @SuppressLint("StaticFieldLeak")
    private static AdMobLib adMobHelper;

    private Context context;
    private InterstitialAd interstitialAd;

    public AdMobLib(Context context){
        this.context = context;
        MobileAds.initialize(context);
    }

    public static AdMobLib instance(Context context){
        if(adMobHelper == null)
            adMobHelper = new AdMobLib(context);

        return adMobHelper;
    }

    public void loadBanner(AdView adView){
        adView.loadAd(new AdRequest.Builder().build());
    }

    public void loadInterstitial(String adUnitId){
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(adUnitId);
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        });
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }
}
