package com.thetapractice.KotlinProjectBatchNov2022.Model

data class StudentDeleteResponse(
    val status:Boolean,
    val result:APIStudent,
    val message:String
)
