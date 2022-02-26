package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.sampleproject.databinding.ActivityFirstPageOfHospitalBinding
const val DOCTOR = "doctor"
class firstPageOfHospital : AppCompatActivity() {

    lateinit var binding: ActivityFirstPageOfHospitalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageOfHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Hospital.doctorList
        val buttonsList= arrayListOf(binding.button,binding.button2,binding.button3)

        binding.button.text = Hospital.doctorList[0].name
        binding.button2.text = Hospital.doctorList[1].name
        binding.button3.text = Hospital.doctorList[2].name
         var intent = Intent(this , DoctorActivity::class.java)




    }
    fun goToDoctorActivity(doctor: Doctor):Doctor{
        var intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra( DOCTOR,doctor)

    }

}


