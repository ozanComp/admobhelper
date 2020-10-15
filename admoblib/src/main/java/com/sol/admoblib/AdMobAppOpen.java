package com.sol.admoblib;

import android.app.Activity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

public abstract class AdMobAppOpen extends AdMobLib {
    private Activity activity;
    private String adUnitId;
    private AppOpenAd ad;

    public abstract void onLoad();
    public abstract void onFailedLoad();

    public AdMobAppOpen(Activity activity, String adUnitId) {
        super(activity);
        this.activity = activity;
        this.adUnitId = adUnitId;
    }

    @Override
    public void load(){
        AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAppOpenAdLoaded(AppOpenAd ad) {
                AdMobAppOpen.this.ad = ad;
                onLoad();
            }

            @Override
            public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                onFailedLoad();
            }

        };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(activity, adUnitId, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    @Override
    public void show(){
        ad.show(activity, new FullScreenContentCallback());
    }
}
