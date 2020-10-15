package com.sol.admoblib;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdMobBanner extends AdMobLib{
    private AdView adView;

    public AdMobBanner(Context context, AdView adView){
        super(context);
        this.adView = adView;
    }

    @Override
    public void load() {
        adView.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void show() {
        adView.loadAd(new AdRequest.Builder().build());
    }
}
