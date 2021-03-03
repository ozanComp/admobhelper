package com.sol.admoblib;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public abstract class AdMobReward extends AdMobLib{
    public abstract void onLoad();
    public abstract void onOpen();
    public abstract void onClose();
    public abstract void onFailedLoad(LoadAdError adError);
    public abstract void onEarnedReward(@NonNull RewardItem reward);
    public abstract void onFailedEarnedReward(AdError adError);

    private String adUnitId;
    private Activity activity;
    private RewardedAd rewardedAd;

    public AdMobReward(Activity activity, String adUnitId){
        super(activity);
        this.activity = activity;
        this.adUnitId = adUnitId;
    }

    @Override
    public void load(){
        rewardedAd = new RewardedAd(activity, adUnitId);

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                onLoad();
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                onFailedLoad(adError);
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

    @Override
    public void show(){
        RewardedAdCallback adCallback = new RewardedAdCallback() {
            @Override
            public void onUserEarnedReward(@NonNull RewardItem reward) {
                onEarnedReward(reward);
            }

            @Override
            public void onRewardedAdFailedToShow(AdError adError) {
                onFailedEarnedReward(adError);
            }

            @Override
            public void onRewardedAdOpened() {
                onOpen();
            }

            @Override
            public void onRewardedAdClosed() {
                onClose();
            }
        };
        rewardedAd.show(activity, adCallback);
    }
}
