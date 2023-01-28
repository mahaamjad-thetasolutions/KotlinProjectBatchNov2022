package com.thetapractice.KotlinProjectBatchNov2022.DAO

import androidx.room.*
import com.thetapractice.KotlinProjectBatchNov2022.Model.Patient

@Dao
interface PatientDAO {

    @Insert
    fun savePatient(patient:Patient)

    @Update
    fun updatePatient(patient:Patient)

    @Delete
    fun deletePatient(patient: Patient)

    @Query("Select * from Patient")
    fun getAllPatients():List<Patient>
}