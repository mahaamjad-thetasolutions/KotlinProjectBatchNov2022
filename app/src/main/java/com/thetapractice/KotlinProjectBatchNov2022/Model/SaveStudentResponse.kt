package com.thetapractice.KotlinProjectBatchNov2022.Model

data class SaveStudentResponse(   val status:Boolean,
                                  val result:APIStudent,
                                  val message:String
)

