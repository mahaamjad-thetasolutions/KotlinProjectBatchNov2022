package com.thetapractice.KotlinProjectBatchNov2022.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true)
    var Id:Int,
    @ColumnInfo(name = "PatientName")
    var Name:String,
    var PhoneNumber:String,
    var Age:Int,
    var disease:String,
    var IsOPDPatient:Boolean,
    var Address:String
)
