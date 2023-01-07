package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible

import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var userEmail:String
    lateinit var user0Password:String
    lateinit var userGender:String
    lateinit var userHobbies:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val username:EditText=findViewById(R.id.edtUsername)
        btnSubmit.setOnClickListener {
             userEmail= username.text.toString()
             user0Password=edtPassword.text.toString()
            getGenderValue()
            getHobbies()
            //validateUserDetails()
        }

        genderRG.setOnCheckedChangeListener { radioGroup, checkedid ->
           when(checkedid){
               R.id.rbMale->
               {
                   userGender="Male"
                   Toast.makeText(this,userGender,Toast.LENGTH_LONG).show()
//                   coding.isVisible=true
//                   Traveling.isVisible=true
//                   Garedning.isVisible=false
//                   Readingbook.isVisible=false
//                   Art.isVisible=false
               }
               R.id.rbFeMale->{
                   userGender="Female"
                   Toast.makeText(this,userGender,Toast.LENGTH_LONG).show()
//                   coding.isVisible=false
//                   Traveling.isVisible=false
//                   Garedning.isVisible=true
//                   Readingbook.isVisible=true
//                   Art.isVisible=true
               }
               R.id.rbOther->{
                   userGender="Other"
                   Toast.makeText(this,userGender,Toast.LENGTH_LONG).show()
//                   coding.isVisible=true
//                   Traveling.isVisible=true
//                   Garedning.isVisible=true
//                   Readingbook.isVisible=true
//                   Art.isVisible=true
               }
           }
        }
    }

    private fun getHobbies() {
        userHobbies=""
        if(Art.isChecked)
        {
            userHobbies="Art"
        }
        if(Garedning.isChecked)
        {
            userHobbies=userHobbies+", Gardening"
        }
        if(Traveling.isChecked)
        {
            userHobbies=userHobbies+", Traveling"
        }
        if(Readingbook.isChecked)
        {
            userHobbies=userHobbies+", Reading Books"
        }
        if(coding.isChecked)
        {
            userHobbies=userHobbies+", Coding"
        }
        Toast.makeText(this, userHobbies,Toast.LENGTH_LONG).show()
    }

    private fun getGenderValue() {
        if(rbMale.isChecked)
        {
            userGender="Male"
        }
        else if(rbFeMale.isChecked)
        {
            userGender="Female"
        }
        else {
            userGender="Other"
        }
    }

    private fun validateUserDetails() {
        if(validateEmail()&&validatePassword())
        {
            movetoNextActitvity()
        }
    }

    private fun movetoNextActitvity() {
        val intent= Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.putExtra("EMAIL",userEmail)
        intent.putExtra("PASSWORD",user0Password)
        intent.putExtra("USERNAME",userEmail)
        startActivity(intent)
    }

    private fun validateEmail(): Boolean {

        if(userEmail.isEmpty())
        {
            edtUsername.error="Required"
            return false
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            edtUsername.error="Enter Correct Email"
            return false
        }
        else{
            return true
        }

    }

    private fun validatePassword (): Boolean {
        if(user0Password.isEmpty())
        {
            edtPassword.error="Required"
            return false
        }
        else{
            //var regexForPasswordValidation= Pattern.compile("^[0-9]{5}-[0-9]{7}-[0-9]{1}\$")
            var regexForPasswordValidation= Pattern.compile("^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#\$%&? \"]).*\$")

            if(!regexForPasswordValidation.matcher(user0Password).matches())
            {
                edtPassword.error="Password should be atleast 8 characters and consist of Lowercase, uppercase & special symbols."
                return false
            }
            else{
                return true
            }
        }

    }
}