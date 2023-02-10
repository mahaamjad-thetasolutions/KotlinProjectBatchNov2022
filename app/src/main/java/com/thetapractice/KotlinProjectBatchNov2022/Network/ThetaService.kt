package com.thetapractice.KotlinProjectBatchNov2022.Network

import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ThetaService {

    @GET("/api/StudentList")
    fun getStudentList(): Call<StudentListResponse>



    companion object{
        fun getRetrofitObject():ThetaService?{
            var retroFitObject: Retrofit? =null
            if(retroFitObject==null)
            {
                retroFitObject= Retrofit.Builder()
                    .baseUrl("https://apis.theta.solutions")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retroFitObject?.create(ThetaService::class.java)
        }
    }
}