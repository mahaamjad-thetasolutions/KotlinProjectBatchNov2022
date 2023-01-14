package com.thetapractice.KotlinProjectBatchNov2022.DoctorList

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thetapractice.KotlinProjectBatchNov2022.Model.Doctor
import com.thetapractice.KotlinProjectBatchNov2022.R
import kotlinx.android.synthetic.main.doctor_item_view.view.*

class DoctorListAdapter(var doctorClickListener:DoctorListClickListener) :RecyclerView.Adapter<DoctorListAdapter.doctorViewHolder>(){

    lateinit var DoctorList:ArrayList<Doctor>
    class doctorViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): doctorViewHolder {

        var viewHolder=LayoutInflater.from(parent.context).inflate(R.layout.doctor_item_view,parent,false)
        return  doctorViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: doctorViewHolder , position: Int) {
        var doctor=DoctorList[position]
        holder.itemView.doctorName.text=doctor.Name
        holder.itemView.doctorAge.text=doctor.Age.toString()
        holder.itemView.doctorSpecialization.text=doctor.Sepcialization
        if(doctor.Age>30)
        {
            holder.itemView.setBackgroundColor(Color.BLUE)
        }
        else{
            holder.itemView.setBackgroundColor(Color.YELLOW)
        }
        holder.itemView.setOnClickListener {
            doctorClickListener.itemClickListener(doctor)
        }
    }

    override fun getItemCount(): Int {
        return DoctorList.count()
    }
    fun getDoctorListFromActivity(list:ArrayList<Doctor>){
        DoctorList = list
    }
}