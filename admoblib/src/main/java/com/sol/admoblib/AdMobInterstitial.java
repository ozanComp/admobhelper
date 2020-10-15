package com.sol.admoblib;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public abstract class AdMobInterstitial extends AdMobLib{
    public abstract void onLoad();

    private String adUnitId;
    private Context context;
    private InterstitialAd interstitialAd;

    public AdMobInterstitial(Context context, String adUnitId){
        super(context);
        this.context = context;
        this.adUnitId = adUnitId;
    }

    @Override
    public void load() {
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(adUnitId);
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                onLoad();
            }
        });
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void show(){
        if(interstitialAd != null)
            interstitialAd.show();
    }
}
