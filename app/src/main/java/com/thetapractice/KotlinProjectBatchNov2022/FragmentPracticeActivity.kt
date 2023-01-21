package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment_practice.*

class FragmentPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_practice)
        btnSignUp.setOnClickListener{
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentFrameLayout,SignUpFragment())
            transaction.commit()
        }
        btnSignIn.setOnClickListener{
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentFrameLayout,SignInFragment())
            transaction.commit()
        }
    }
}