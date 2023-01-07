package com.thetapractice.KotlinProjectBatchNov2022

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val email=intent.getStringExtra("EMAIL")
        val username=intent.getStringExtra("USERNAME")
        val password=intent.getStringExtra("PASSWORD")

        Toast.makeText(this,username, Toast.LENGTH_LONG).show()
        btntwo.text=username
    }


}