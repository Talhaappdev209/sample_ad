package com.appcode.sampleadd

import android.app.Activity
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class Myrewardedad(private val activity: Activity) {

    private var rewardedAd : RewardedAd?= null
    fun loadad (adunitIdl:Int){
        val adRequest= AdRequest.Builder().build()


        RewardedAd.load(
            activity,
            activity.getString(adunitIdl),
            adRequest,
            object:RewardedAdLoadCallback(){
                override fun onAdLoaded(mRewardedAd: RewardedAd) {
                    rewardedAd=mRewardedAd
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    rewardedAd =null
                }
            }

        )
    }


    fun ShowRewardedAds(adunitIdl: Int, afterCodeRewardedcoin:(RewardItem)->Unit){
        if (rewardedAd!=null){
            rewardedAd!!.fullScreenContentCallback=object:FullScreenContentCallback (){
                override fun onAdDismissedFullScreenContent() {
                    rewardedAd=null
                    loadad(adunitIdl)
                }
            }
            rewardedAd!!.show(activity){
                afterCodeRewardedcoin(it)
        }


        }
        else {

            Toast.makeText(activity,"Ad is loaded",Toast.LENGTH_SHORT).show()
        }
        }

        }
