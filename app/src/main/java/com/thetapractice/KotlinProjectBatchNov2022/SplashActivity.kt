package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.thetapractice.KotlinProjectBatchNov2022.Helper.KotlinNovSharedPrefs

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {moveToNextActivity()},
            3000)
    }

    private fun moveToNextActivity() {
        KotlinNovSharedPrefs(this).saveUserNaneInSP("Theta Admin")
        startActivity(Intent(this,LifeCycleActivity::class.java))
    finish()
    }
}