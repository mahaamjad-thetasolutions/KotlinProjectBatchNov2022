package com.thetapractice.KotlinProjectBatchNov2022.Helper

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaCodec.MetricsConstants.MODE

class KotlinNovSharedPrefs(context: Context){
    val sharedPrefs:SharedPreferences=context.getSharedPreferences("ThETA_SHAREDPREF",Context.MODE_PRIVATE)

    fun saveUserNaneInSP(username:String){
        sharedPrefs.edit().putString("Login_USER_USERNAME",username).apply()
    }
    fun getUserNaneFromSP(): String? {
        var username= sharedPrefs.getString("Login_USER_USERNAME","")
        return username
    }
    fun clearSharedPrefs(){
        sharedPrefs.edit().clear().apply()
    }

    fun clearUserRegion(){
        sharedPrefs.edit().remove("Login_USER_USERNAME").apply()
    }
}