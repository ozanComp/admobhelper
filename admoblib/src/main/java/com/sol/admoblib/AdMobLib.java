package com.sol.admoblib;

import android.content.Context;

import com.google.android.gms.ads.MobileAds;

public class AdMobLib implements AdMobLibInterface {
    public AdMobLib(Context context){
        MobileAds.initialize(context);
    }


    @Override
    public void load(){
    }

    @Override
    public void show(){

    }
}
