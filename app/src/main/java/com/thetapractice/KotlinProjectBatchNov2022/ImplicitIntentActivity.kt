package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_implicit_intent.*

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        //2 types of Intent
        //Explicit Intent
        //Implicit Intent

        btnView.setOnClickListener {
           val number=edtURL.text.toString()
            val url="tel:"+edtURL.text.toString()
//           // val i = Intent(Intent.ACTION_VIEW , Uri.parse(url))
//            val i =Intent(Intent.ACTION_DIAL , Uri.parse(url))
//            startActivity(Intent.createChooser(i,Intent.ACTION_DIAL))
//            val url = "https://api.whatsapp.com/send?phone=$number"
//            val i = Intent(Intent.ACTION_VIEW)
//            i.data = Uri.parse(url)
//            startActivity(i)
//            val i=Intent(Intent.ACTION_VIEW , Uri.parse("geo:32.5239889,74.5746978"))
//            startActivity(Intent.createChooser(i,Intent.ACTION_VIEW))
            val i=Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:info@thetasolutions@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT,"Query ABout Trainings")
            i.putExtra(Intent.EXTRA_TEXT,"What is your fee for ANdroid development with kotlin?")

            i.setType("message/rfc822");
            startActivity(Intent.createChooser(i,Intent.ACTION_SEND))
        }

    }
}