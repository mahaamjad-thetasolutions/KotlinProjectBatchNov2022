package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thetapractice.KotlinProjectBatchNov2022.Helper.KotlinNovSharedPrefs
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val email=intent.getStringExtra("EMAIL")
        val username=intent.getStringExtra("USERNAME")
        val password=intent.getStringExtra("PASSWORD")

        Toast.makeText(this , KotlinNovSharedPrefs(this).getUserNaneFromSP() , Toast.LENGTH_LONG).show()
        btntwo.setOnClickListener {
            KotlinNovSharedPrefs(this).clearSharedPrefs()
            startActivity(Intent(this , LifeCycleActivity::class.java))
        }
    }


}