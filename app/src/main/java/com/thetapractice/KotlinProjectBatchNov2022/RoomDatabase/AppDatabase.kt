package com.thetapractice.KotlinProjectBatchNov2022.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thetapractice.KotlinProjectBatchNov2022.DAO.PatientDAO
import com.thetapractice.KotlinProjectBatchNov2022.Model.Patient

@Database( entities = [Patient::class] , version = 2)
abstract class AppDatabase(): RoomDatabase() {

    abstract fun patientdao():PatientDAO

    companion object{
        fun getDatabase(context: Context):AppDatabase{
            var HMSdatabase: AppDatabase? =null
            if(HMSdatabase!=null){
                return  HMSdatabase
            }
            HMSdatabase= Room.databaseBuilder(context,AppDatabase::class.java,"HMS_DB").allowMainThreadQueries().fallbackToDestructiveMigration().build()
            return  HMSdatabase
        }
    }
}