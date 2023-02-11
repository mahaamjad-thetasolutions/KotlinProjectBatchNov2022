package com.thetapractice.KotlinProjectBatchNov2022.Network

import com.thetapractice.KotlinProjectBatchNov2022.Model.SaveStudentResponse
import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentDeleteResponse
import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentListResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ThetaService {

    @GET("/api/StudentList")
    fun getStudentList(): Call<StudentListResponse>

    @GET("/api/DeleteStudent")
    fun deleteStudentFromList( @Query("id") id:Int):Call<StudentDeleteResponse>

    @POST("/api/AddStudent")
    fun SaveStudentInDB( @Body body:RequestBody):Call<SaveStudentResponse>

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