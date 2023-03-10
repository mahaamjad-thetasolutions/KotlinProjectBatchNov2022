package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_drop_down.*

class DropDownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_down)
        var selectedLanguage=""
       var pakistanLanguage=resources.getStringArray(R.array.PakistanLanguages)
        languageSpinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,pakistanLanguage)

        languageSpinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>? , p1: View? , p2: Int , p3: Long) {
               // SweetSuccess(message = "Success Text!", duration = Toast.LENGTH_SHORT, padding = PaddingValues(top = 16.dp), contentAlignment = Alignment.TopCenter)
                //toastOrEgg( pakistanLanguage[p2], 1, R.color.Mouve)
                selectedLanguage=pakistanLanguage[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
//        button.click{
//            Doctor(name, id, hobbies, selectedLanguage)
//        }
    }
}