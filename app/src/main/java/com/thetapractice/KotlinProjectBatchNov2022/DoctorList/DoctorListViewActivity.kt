package com.thetapractice.KotlinProjectBatchNov2022.DoctorList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.thetapractice.KotlinProjectBatchNov2022.Model.Doctor
import com.thetapractice.KotlinProjectBatchNov2022.R
import com.thetapractice.KotlinProjectBatchNov2022.RoomDatabase.AppDatabase
import kotlinx.android.synthetic.main.activity_doctor_list_view.*

class DoctorListViewActivity : AppCompatActivity(),DoctorListClickListener {
    var docAdapter=DoctorListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list_view)
        doctorRecylerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        doctorRecylerView.adapter=docAdapter
        getDoctorList()
    }

    private fun getDoctorList() {
       val doctorList:ArrayList<Doctor> = arrayListOf()
       //val patientList= AppDatabase.getDatabase(this).patientdao().getAllPatients()

        doctorList.add(Doctor("Ali Muhsin",37,"Neurologist"))
        doctorList.add(Doctor("Usman Ali",45,"Dermatologist"))
        doctorList.add(Doctor("Ahmed Muhsin",78,"Hematologist"))
        doctorList.add(Doctor("Safa Hayat",26,"Medical Specialist"))
        doctorList.add(Doctor("Ali Noor",87,"Dentist"))
        doctorList.add(Doctor("Sana Javed",47,"Diabetes Specialist"))
        doctorList.add(Doctor("Touba Shoukat",34,"Orthopaedic"))
        doctorList.add(Doctor("Mona Muhsin",29,"Neurologist"))

        docAdapter.getDoctorListFromActivity(doctorList)

    }

    override fun itemClickListener(doctor: Doctor) {
        Toast.makeText(this,doctor.Sepcialization,Toast.LENGTH_LONG).show()
    }

}
