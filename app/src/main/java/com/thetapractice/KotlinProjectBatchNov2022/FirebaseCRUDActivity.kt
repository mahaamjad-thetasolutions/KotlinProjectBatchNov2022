package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.thetapractice.KotlinProjectBatchNov2022.Model.Doctor
import com.thetapractice.KotlinProjectBatchNov2022.Model.Nurse

class FirebaseCRUDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_crudactivity)
        val firebaseDatabase=FirebaseDatabase.getInstance("https://kotlinbatchnov-default-rtdb.firebaseio.com/")
        val dbNode=firebaseDatabase.getReference("HospitalNurse")
        val key=dbNode.push().key
        val Doctor=Doctor("Sana Javed",47,"Diabetes Specialist")

        val nurse=Nurse(key , "Ali" , "09875434" , 25 , "BS Nursing" , "Khadim Ali Road",Doctor)
        if (key != null) {
            dbNode.child(key).setValue(nurse).addOnCompleteListener{
                if(it.isSuccessful)
                {
                    Toast.makeText(this , "Data ENtered", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this , "Error While addding data", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}