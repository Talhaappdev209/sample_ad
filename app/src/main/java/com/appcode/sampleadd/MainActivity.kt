package com.appcode.sampleadd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val loadrewardedAd = findViewById<Button>(R.id.rewardedad)
        val rewardedAdamount = findViewById<TextView>(R.id.rewardedadamount)

        val myrewardedad = Myrewardedad(this)
        myrewardedad.loadad(R.string.rewarded)

        loadrewardedAd.setOnClickListener {
            myrewardedad.ShowRewardedAds(R.string.rewarded){

            }

        }
    }
}