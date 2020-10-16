# admobhelper

Admob library for Android

Gradle Setup
--------

repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ozanComp:admobhelper:1.2'
    implementation 'com.google.firebase:firebase-ads:19.4.0'
}

Manifest
--------

Insert INTERNET Permission

Insert meta-data with your AD ID



Using
-----------

For Banner Ads:
Using AdMobBanner Object.

For Interstitial Ads:
Using AdMobInterstitial Object.

For Native Ads:
Using AdMobNative Object.

For Reward Ads:
Using AdMobReward Object.

For App Open Ads:
Using AdMobAppOpen Object.
