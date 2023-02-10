package com.thetapractice.KotlinProjectBatchNov2022

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thetapractice.KotlinProjectBatchNov2022.Helper.KotlinNovSharedPrefs
import com.thetapractice.KotlinProjectBatchNov2022.Model.StudentListResponse
import com.thetapractice.KotlinProjectBatchNov2022.Network.ThetaService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val email=intent.getStringExtra("EMAIL")
        val username=intent.getStringExtra("USERNAME")
        val password=intent.getStringExtra("PASSWORD")

        Toast.makeText(this , KotlinNovSharedPrefs(this).getUserNaneFromSP() , Toast.LENGTH_LONG).show()
//        btntwo.setOnClickListener {
//            KotlinNovSharedPrefs(this).clearSharedPrefs()
//            startActivity(Intent(this , LifeCycleActivity::class.java))
//        }
        getStudentListFromAPI()
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


}