package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d("LifeCycleLog","Activity is in OnCreate() state")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycleLog","Activity is in OnStart() state")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycleLog","Activity is in OnResume() state")
    }

}