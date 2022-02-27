package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityHospitalFirstPageBinding

const val DOCTOR = "doctor"
class HospitalFirstPage : AppCompatActivity() {

    lateinit var binding: ActivityHospitalFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Hospital.doctorList
        Hospital.setTestData()
        val buttonsList= arrayListOf(binding.button,binding.button2,binding.button3)

        binding.button.text =  Hospital.doctorList[0].name
        binding.button2.text = Hospital.doctorList[1].name
        binding.button3.text = Hospital.doctorList[2].name

        for(i in 0 until buttonsList.size){
            buttonsList[i].setOnClickListener{
                goToDoctorActivity(Hospital.doctorList[i])
            }
        }






    }
    fun goToDoctorActivity(doctor: Doctor){
        var intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra( DOCTOR,doctor)
        startActivity(intent)

    }

}


