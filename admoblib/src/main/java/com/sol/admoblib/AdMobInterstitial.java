package com.sol.admoblib;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

public abstract class AdMobInterstitial extends AdMobLib{
    public abstract void onLoad();
    public abstract void onLoadFailed();
    public abstract void onOpened();
    public abstract void onClosed();

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

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                onLoadFailed();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                onOpened();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                onClosed();
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
