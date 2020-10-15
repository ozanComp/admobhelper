# admobhelper

Admob library for Android

Gradle Setup
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.ozanComp:admobhelper:1.2'
    implementation 'com.google.firebase:firebase-ads:19.4.0'
}

Manifest
<uses-permission android:name="android.permission.INTERNET" />
<meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="--AD ID--"/>

For Banner Ads:
Using AdMobBanner.

For Interstitial Ads:
Using AdMobInterstitial.

For Native Ads:
Using AdMobNative.

For Reward Ads:
Using AdMobReward.

For App Open Ads:
Using AdMobAppOpen.


Download the https://play.google.com/store/apps/details?id=com.sol.admobhelper for example app.
