package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.thetapractice.KotlinProjectBatchNov2022.Helper.KotlinNovSharedPrefs
import com.thetapractice.KotlinProjectBatchNov2022.Model.SaveStudentResponse
import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentDeleteResponse
import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentListResponse
import com.thetapractice.KotlinProjectBatchNov2022.Network.ThetaService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         FirebaseMessaging.getInstance().token.addOnCompleteListener { task->
            if(task.isSuccessful)
            {
                Toast.makeText(this , task.result.toString(), Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this , "Token not generated", Toast.LENGTH_LONG).show()
            }
        }

        var dialog=AlertDialog.Builder(this)
        dialog.setTitle("Confirmation!")
        dialog.setMessage("Are you sure you wnat to Exit?")
        dialog.setIcon(R.drawable.ic_baseline_account_box_24)
        dialog.setPositiveButton("Sure"){dialog,which->
            finish()
        }
        dialog.setNegativeButton("No"){dialog, which->
            dialog.cancel()
        }
        dialog.create()
        dialog.show()


    }
    private fun saveStudentInDB() {
        var student=getStudent()
        var call=ThetaService.getRetrofitObject()?.SaveStudentInDB(student)


        call?.enqueue(object: Callback<SaveStudentResponse>{
            override fun onResponse(
                call: Call<SaveStudentResponse> ,
                response: Response<SaveStudentResponse>
            ) {
                Toast.makeText(baseContext ,response.body()?.message , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<SaveStudentResponse> , t: Throwable) {
                Toast.makeText(baseContext ,t.localizedMessage , Toast.LENGTH_LONG).show()
            }


        })
    }

    private fun getStudent(): RequestBody {

        var student=MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("Name","Ali")
            .addFormDataPart("Department","Electronics")
            .addFormDataPart("Cgpa","2.3")
            .addFormDataPart("Email","ali@gmail.com")
            .addFormDataPart("Username","Ali12345")
            .addFormDataPart("Password","123456")
            .addFormDataPart("IsActive","1").build()
        return student
    }

    private fun getStudentListFromAPI() {
      var call=ThetaService.getRetrofitObject()?.getStudentList()


        call?.enqueue(object: Callback<StudentListResponse>{
            override fun onResponse(
                call: Call<StudentListResponse> ,
                response: Response<StudentListResponse>
            ) {
                response.body()?.result?.first()?.name?.let { Log.d("StudentList" , it.toString()) }
            }

            override fun onFailure(call: Call<StudentListResponse> , t: Throwable) {
                Toast.makeText(baseContext ,t.localizedMessage , Toast.LENGTH_LONG).show()

            }

        })
    }
    private fun deleteStudentFromListFromAPI() {
        var call=ThetaService.getRetrofitObject()?.deleteStudentFromList(12)


        call?.enqueue(object: Callback<StudentDeleteResponse>{
            override fun onResponse(
                call: Call<StudentDeleteResponse> ,
                response: Response<StudentDeleteResponse>
            ) {
                Toast.makeText(baseContext ,response.body()?.message , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<StudentDeleteResponse> , t: Throwable) {
                Toast.makeText(baseContext ,t.message , Toast.LENGTH_LONG).show()
            }


        })
    }


}