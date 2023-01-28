package com.thetapractice.KotlinProjectBatchNov2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            val bundle = Bundle()
            bundle.putString("Userame" , "Theta")
            bundle.putInt("ji",2)
            SignInFragment().setArguments(bundle)
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentFrameLayout,SignInFragment())
            transaction.commit()
        }
    }
}