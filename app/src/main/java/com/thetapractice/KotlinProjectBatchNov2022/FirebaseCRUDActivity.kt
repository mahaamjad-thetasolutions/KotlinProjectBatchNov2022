package com.thetapractice.KotlinProjectBatchNov2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.thetapractice.KotlinProjectBatchNov2022.Model.Doctor
import com.thetapractice.KotlinProjectBatchNov2022.Model.Nurse

class FirebaseCRUDActivity : AppCompatActivity() {
    val firebaseDatabase=FirebaseDatabase.getInstance("https://kotlinbatchnov-default-rtdb.firebaseio.com/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_crudactivity)
        //saveDataInFirebaseDatabase()
        getNourseList()
    }

    private fun getNourseList() {
        val nurseList:ArrayList<Nurse> = arrayListOf()
        val dbNode=firebaseDatabase.getReference("HospitalNurse")
        var nurseData=dbNode
        nurseData.addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    for(i in snapshot.children)
                    {
                        val nurse= i.getValue(Nurse::class.java)
                        if (nurse != null) {
                            nurseList.add(nurse)
                        }
                    }
                    //send list to adapter
                    //docAdapter.getDoctorListFromActivity(nurseList)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(baseContext , "Error While fetching data", Toast.LENGTH_LONG).show()
            }
        }

        )
    }

    private fun saveDataInFirebaseDatabase() {
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
    private fun deleteNurse(nurse: Nurse) {
        // Toast.makeText(this,doctor.Qualification,Toast.LENGTH_LONG).show()
        var dialog= AlertDialog.Builder(this)
        dialog.setTitle("Delete Confirmation!")
        dialog.setMessage("Are you sure you wnat to Delete this Nurse From System?")
        dialog.setIcon(R.drawable.ic_baseline_account_box_24)
        dialog.setPositiveButton("Sure"){dialog,which->
            var data= nurse.Id?.let { firebaseDatabase.getReference("HospitalNurse").child(it) }
            var task=data?.removeValue()
            task?.addOnCompleteListener { task->
                if(task.isSuccessful)
                {
                    Toast.makeText(baseContext , "Data deleted", Toast.LENGTH_LONG).show()
                    dialog.cancel()
                }
                else{
                    Toast.makeText(baseContext , "Error While deleting data", Toast.LENGTH_LONG).show()
                    dialog.cancel()
                }

            }
        }
        dialog.setNegativeButton("No"){dialog, which->
            dialog.cancel()
        }
        dialog.create()
        dialog.show()
    }
}