package com.sol.admoblib;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public abstract class AdMobNative extends AdMobLib{
    private VideoController videoController;
    private NativeExpressAdView nativeExpressAdView;

    public abstract void onEnd();
    public abstract void onLoad();

    public AdMobNative(Context context, NativeExpressAdView nativeExpressAdView){
        super(context);
        this.nativeExpressAdView = nativeExpressAdView;
    }

    @Override
    public void load(){
        nativeExpressAdView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());
        videoController = nativeExpressAdView.getVideoController();
        videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                super.onVideoEnd();
                onEnd();
            }
        });

        nativeExpressAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (videoController.hasVideoContent()) {
                    onLoad();
                }
            }
        });

        nativeExpressAdView.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void show(){
        if(videoController != null)
            videoController.play();
    }
}
