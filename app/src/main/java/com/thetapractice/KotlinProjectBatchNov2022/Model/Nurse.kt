package com.thetapractice.KotlinProjectBatchNov2022.Model

data class Nurse(
    var Id:String?="" ,
    var Name:String="" ,
    var PhoneNumber:String="" ,
    var Age:Int=0 ,
    var Qualification:String="" ,
    var Address:String="" ,
    var seniorDoctor: Doctor? =null
)
