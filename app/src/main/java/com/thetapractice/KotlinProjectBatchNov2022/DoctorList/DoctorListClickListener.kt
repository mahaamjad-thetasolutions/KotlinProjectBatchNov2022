package com.thetapractice.KotlinProjectBatchNov2022.DoctorList

import com.thetapractice.KotlinProjectBatchNov2022.Model.Doctor

interface DoctorListClickListener {
    fun itemClickListener(doctor: Doctor)
}