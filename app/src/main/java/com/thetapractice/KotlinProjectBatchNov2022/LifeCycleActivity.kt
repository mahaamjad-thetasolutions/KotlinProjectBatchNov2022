package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.thetapractice.KotlinProjectBatchNov2022.Helper.KotlinNovSharedPrefs
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        loggedInUserName.text = KotlinNovSharedPrefs(this).getUserNaneFromSP()
        move.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
        }
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