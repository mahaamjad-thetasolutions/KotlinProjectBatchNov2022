package com.thetapractice.KotlinProjectBatchNov2022.Model

data class StudentListResponse(
    val status:Boolean,
    val result:List<APIStudent>,
    val message:String
)

data class APIStudent(
    val id:Int,
    val name:String,
    val department:String,
    val cgpa:Float,
    val email:String,
    val username:String,
    val password:String,
    val isActive:Boolean
)
